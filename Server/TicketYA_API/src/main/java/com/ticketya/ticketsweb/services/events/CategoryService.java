package com.ticketya.ticketsweb.services.events;

import java.util.List;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.SaveCategoryEventDTO;
import com.ticketya.ticketsweb.models.entities.event.CategoryEvent;
import com.ticketya.ticketsweb.models.entities.event.Event;

public interface CategoryService {
	/*
	 * Save, delete
	*/
	List<CategoryEvent> findAll();
	MessageResultDTO save(SaveCategoryEventDTO inf) throws Exception;
	MessageResultDTO delete(UUID id) throws Exception;
	
	
}
