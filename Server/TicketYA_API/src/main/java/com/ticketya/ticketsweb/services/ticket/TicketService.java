package com.ticketya.ticketsweb.services.ticket;

import java.util.UUID;
import java.util.List;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.ChangeOwnerDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.CreateTicketDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.ShowTicketDTO;
import com.ticketya.ticketsweb.models.entities.ticket.Ticket;
import com.ticketya.ticketsweb.utils.PageDTO;

public interface TicketService {
	/*
	 * save, ToggleActive, findOneById, findAll,findOneWhereUserid,
	 * findAllWhereUserid, findOneByOwner, changeOwner
	*/
	
	MessageResultDTO save(CreateTicketDTO info) throws Exception;
	MessageResultDTO toggleActive(UUID id) throws Exception;
	List<ShowTicketDTO> findAll();
	ShowTicketDTO findOneByid(UUID id);
	List<ShowTicketDTO> findAllWhereUserid(UUID id);
	MessageResultDTO changeOwner(ChangeOwnerDTO changeOwnerDTO) throws Exception;
	
	//pagination
	PageDTO<ShowTicketDTO> findAllWhereUseridpage(String token, int page, int size);
}
