package com.ticketya.ticketsweb.services.events;

import java.util.List;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.SaveCategoryEventDTO;
import com.ticketya.ticketsweb.models.dtos.event.SaveCollaboratorDTO;
import com.ticketya.ticketsweb.models.entities.event.CategoryEvent;
import com.ticketya.ticketsweb.models.entities.event.Collaborator;

public interface CollaboratorService {
	/*
	 * Save, delete
	*/
	List<Collaborator> findAll();
	MessageResultDTO save(SaveCollaboratorDTO inf) throws Exception;
	MessageResultDTO delete(UUID id) throws Exception;
	
}
