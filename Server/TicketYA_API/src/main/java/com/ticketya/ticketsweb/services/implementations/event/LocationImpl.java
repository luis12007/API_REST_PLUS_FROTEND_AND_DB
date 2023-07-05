package com.ticketya.ticketsweb.services.implementations.event;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.CreateLocationDTO;
import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.models.entities.event.Location;
import com.ticketya.ticketsweb.repositories.event.EventRespository;
import com.ticketya.ticketsweb.repositories.event.LocationRepository;
import com.ticketya.ticketsweb.services.events.LocationService;

@Service
public class LocationImpl implements LocationService{

	@Autowired
	private LocationRepository locationrepo;
	
	@Autowired
	private EventRespository eventrepo;
	
	// All the functions get data from repositorys thats are already import and find 
	// one object by respective type and call again to the repositorys to delete,create,get...
	// The entire CRUD and more
	
	@Override
	public MessageResultDTO save(CreateLocationDTO info) throws Exception {
		//looking to the values of the entitie and add with validations
		 Event event = eventrepo.findById(info.getEvent()).orElse(null);
		 if (event == null) {
			 return new MessageResultDTO("evento no encontrado");
		}
		 
		 Location newLocation = new Location(info.getRating(),
				 info.getName(),
				 event);
		 
		 Location verify =	locationrepo.findAll().stream().filter(e -> e.getName().equals(info.getName()) 
				 && e.getEventlocation().getId_event().equals(info.getEvent()))
				 				.findFirst()
				 				.orElse(null);	
		 
		 if (verify == null) {
			locationrepo.save(newLocation);
			 
			return new MessageResultDTO("creado exitosamente");
		}
		 
		 return new MessageResultDTO("localidad ya creada");
		 
	}

	@Override
	public List<Location> findAll() {
		return locationrepo.findAll();
	}

	@Override
	public MessageResultDTO delete(UUID id) throws Exception {
		locationrepo.deleteById(id);
		return new MessageResultDTO("borrado exitosamente");
		
	}

	@Override
	public List<Location> findAllWhereEvent(UUID id) {

		
		return locationrepo.findAll().stream().filter(e -> e.getEventlocation().getId_event().equals(id)).toList();
	}

}
