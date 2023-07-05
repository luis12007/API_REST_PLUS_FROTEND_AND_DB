package com.ticketya.ticketsweb.services.implementations.event;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.SaveSponsorDTO;
import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.models.entities.event.Sponsor;
import com.ticketya.ticketsweb.repositories.event.EventRespository;
import com.ticketya.ticketsweb.repositories.event.SponsorRepository;
import com.ticketya.ticketsweb.services.events.SponsorService;

@Service
public class SponsorImpl implements SponsorService {
	
	@Autowired
	private SponsorRepository sponrepo;
	
	@Autowired
	private EventRespository eventrepo;

	// All the functions get data from repositorys thats are already import and find 
	// one object by respective type and call again to the repositorys to delete,create,get...
	// The entire CRUD and more
	
	@Override
	public MessageResultDTO save(SaveSponsorDTO info) throws Exception {
		//looking to the values of the entitie and add with validations
		 Event event = eventrepo.findById(info.getEvent()).orElse(null);
		 if (event == null) {
			 return new MessageResultDTO("evento no encontrado");
		}
		 Sponsor newSponsor = new Sponsor(info.getName(),
				 event);
		 
		 Sponsor verify =	sponrepo.findAll().stream().filter(e -> e.getName().equals(info.getName()) 
				 && e.getEventsponsor().getId_event().equals(info.getEvent()))
				 				.findFirst()
				 				.orElse(null);	
		 
		 if (verify == null) {
			sponrepo.save(newSponsor);
			 
			return new MessageResultDTO("creado exitosamente");
		}
		 
		 return new MessageResultDTO("Sponsor ya creado");
		 
	}

	@Override
	public List<Sponsor> findAll() {
		return sponrepo.findAll();
	}


	@Override
	public MessageResultDTO delete(UUID id) throws Exception {
		sponrepo.deleteById(id);
		return new MessageResultDTO("borrado exitosamente");
		
	}

	@Override
	public List<Sponsor> findAllWhereEvent(UUID id) {

		return sponrepo.findAll().stream().filter(e -> e.getEventsponsor().getId_event().equals(id)).toList();
	}

}
