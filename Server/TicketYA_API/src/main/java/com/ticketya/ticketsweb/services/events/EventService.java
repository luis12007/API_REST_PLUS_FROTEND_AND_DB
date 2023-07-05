package com.ticketya.ticketsweb.services.events;

import java.util.List;
import java.util.UUID;


import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.CreateEventDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowEventDTO;
import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.utils.PageDTO;


public interface EventService {
	/*
	 * Save, findAll, findOneById, ToogleActive,FinByCategory
	*/
	MessageResultDTO save(CreateEventDTO info) throws Exception;
	List<Event> findAll();
	Event findOneById(UUID id);
	MessageResultDTO toogleState(UUID id) throws Exception;
	MessageResultDTO togglePanic(UUID id) throws Exception;
	List<Event> FindByCategory(UUID id);
	
	PageDTO<ShowEventDTO> findEventsByCategory(String category,int page, int size);
	PageDTO<ShowEventDTO> findEventsByName(String title,int page, int size);
}
