package com.ticketya.ticketsweb.services.implementations.event;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.SaveCategoryEventDTO;
import com.ticketya.ticketsweb.models.entities.event.CategoryEvent;
import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.models.entities.event.Location;
import com.ticketya.ticketsweb.repositories.event.CategoryRepository;
import com.ticketya.ticketsweb.repositories.event.EventRespository;
import com.ticketya.ticketsweb.services.events.CategoryService;

import jakarta.transaction.Transactional;

@Service
public class CategoryEventImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categorepo;
	
	@Autowired
	private EventRespository eventrepo;

	// All the functions get data from repositorys thats are already import and find 
	// one object by respective type and call again to the repositorys to delete,create,get...
	// The entire CRUD and more
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO save(SaveCategoryEventDTO inf) throws Exception {
		//looking to the values of the entitie and add with validations
		CategoryEvent verify = categorepo.findAll().stream().filter(e -> e.getName().equals(inf.getName())).findFirst().orElse(null);

		if (verify == null) {
			categorepo.save(new CategoryEvent(inf.getName()));
			return new MessageResultDTO("creado exitosamente");
		}
		
		return new MessageResultDTO("categoria ya existente");
		
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO delete(UUID id) throws Exception {
		Event verify = eventrepo.findAll().stream().filter(e -> e.getCategory().getId_category().equals(id)).findFirst().orElse(null);
		if (verify == null) {
			categorepo.deleteById(id);
			return new MessageResultDTO("borrado exitosamente");
		}
		
		return new MessageResultDTO("la categoria esta asociada a algun evento y no puede ser borrado");
		
		
		
	}

	@Override
	public List<CategoryEvent> findAll() {
		// TODO Auto-generated method stub
		return categorepo.findAll();
	}

}
