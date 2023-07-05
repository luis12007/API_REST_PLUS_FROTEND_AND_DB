package com.ticketya.ticketsweb.services.events;

import java.util.List;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.CreateLocationDTO;
import com.ticketya.ticketsweb.models.entities.event.Location;


public interface LocationService {
	/*
	 * Save, delete, findOrderByGroup, findAll, findAllWhereEvent
	*/
	MessageResultDTO save(CreateLocationDTO info) throws Exception;
	List<Location> findAll();
	MessageResultDTO delete(UUID id) throws Exception;
	List<Location> findAllWhereEvent(UUID id);
}
