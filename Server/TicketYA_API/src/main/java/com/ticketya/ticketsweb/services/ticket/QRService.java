package com.ticketya.ticketsweb.services.ticket;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.CreateQRDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.ShowQRDTO;
import com.ticketya.ticketsweb.models.entities.ticket.CategoryTicket;
import com.ticketya.ticketsweb.models.entities.ticket.Ticket;
import com.ticketya.ticketsweb.models.entities.ticket.fk.QR;
import com.ticketya.ticketsweb.models.entities.user.User;

public interface QRService {
	/*
	 * Create, Delete, findTimeByid, findOneByTicket,findAllByUser,
	 * 
	*/
	List<ShowQRDTO> findAll();
	MessageResultDTO create(CreateQRDTO inf) throws Exception;
	MessageResultDTO delete(UUID id) throws Exception;
	Timestamp findTimeByid(UUID id);
	ShowQRDTO findOneByTicket(UUID id);
	List<ShowQRDTO> findAllByUser(UUID id);
}
