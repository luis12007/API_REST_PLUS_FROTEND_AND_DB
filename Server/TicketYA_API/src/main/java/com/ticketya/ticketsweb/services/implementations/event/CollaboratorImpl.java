package com.ticketya.ticketsweb.services.implementations.event;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.SaveCategoryEventDTO;
import com.ticketya.ticketsweb.models.dtos.event.SaveCollaboratorDTO;
import com.ticketya.ticketsweb.models.entities.event.CategoryEvent;
import com.ticketya.ticketsweb.models.entities.event.Collaborator;
import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.repositories.event.CollaboratorRepository;
import com.ticketya.ticketsweb.repositories.event.EventRespository;
import com.ticketya.ticketsweb.services.events.CollaboratorService;

import jakarta.transaction.Transactional;

@Service
public class CollaboratorImpl implements CollaboratorService {
	
	@Autowired
	private CollaboratorRepository collaboratorRepository;
	
	@Autowired
	private EventRespository eventrepo;

	// All the functions get data from repositorys thats are already import and find 
	// one object by respective type and call again to the repositorys to delete,create,get...
	// The entire CRUD and more
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO save(SaveCollaboratorDTO inf) throws Exception {
		//looking to the values of the entitie and add with validations
		Collaborator verify = collaboratorRepository.findAll().stream().filter(e -> e.getName().equals(inf.getName())).findFirst().orElse(null);

		if (verify == null) {
			collaboratorRepository.save(new Collaborator(inf.getName()));
			return new MessageResultDTO("creado exitosamente");
		}
		
		return new MessageResultDTO("categoria ya existente");
		
		
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO delete(UUID id) throws Exception {
		Event verify = eventrepo.findAll().stream().filter(e -> e.getCollaborator().getId_event().equals(id)).findFirst().orElse(null);
		if (verify == null) {
			collaboratorRepository.deleteById(id);
			return new MessageResultDTO("borrado exitosamente");
		}
		
		return new MessageResultDTO("el colaborador esta asociado a algun evento y no puede ser borrado");
		
		
	}

	@Override
	public List<Collaborator> findAll() {
		// TODO Auto-generated method stub
		return collaboratorRepository.findAll();
	}

}
