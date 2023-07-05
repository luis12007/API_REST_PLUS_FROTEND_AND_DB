package com.ticketya.ticketsweb.services.ticket;

import java.util.List;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.SaveCategoryTicketDTO;
import com.ticketya.ticketsweb.models.entities.ticket.CategoryTicket;

public interface CategoryService {
	/*
	 * Create, Delete,returnCapacity, finAllByTicket, ReturnPrice, updatePrice
	 * 
	*/
	List<CategoryTicket> findAll();
	MessageResultDTO create(SaveCategoryTicketDTO inf) throws Exception;
	MessageResultDTO delete(UUID id) throws Exception;
	MessageResultDTO updatePrice(SaveCategoryTicketDTO inf,UUID id) throws Exception;
}
