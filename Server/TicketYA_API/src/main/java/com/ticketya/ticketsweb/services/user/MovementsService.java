package com.ticketya.ticketsweb.services.user;

import java.util.List;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.user.SaveMovementsDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowMovementsDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowUserDTO;
import com.ticketya.ticketsweb.models.entities.user.Movements;
import com.ticketya.ticketsweb.models.entities.user.User;
import com.ticketya.ticketsweb.utils.PageDTO;

public interface MovementsService {
	/*
	 * Create, findAll, findAllWereUserId, delete
	*/
	
	MessageResultDTO save(SaveMovementsDTO info, UUID id) throws Exception;
	MessageResultDTO deleteById(UUID id) throws Exception;
	List<ShowMovementsDTO> findAll();
	List<ShowMovementsDTO> findAllWereUserId(UUID id);
	
	//page
	PageDTO<ShowMovementsDTO> findAll(int page, int size);
}
