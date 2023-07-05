package com.ticketya.ticketsweb.services.user;

import java.util.List;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.user.AssignmentDTO;
import com.ticketya.ticketsweb.models.dtos.user.DeleteRolFromUserDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowMovementsDTO;
import com.ticketya.ticketsweb.models.dtos.user.UserAndRolDTO;
import com.ticketya.ticketsweb.models.entities.user.fks.Assignment;
import com.ticketya.ticketsweb.utils.PageDTO;

public interface AssignmentService {
	/*
	 * Create, findOneWhereUserId, findAllWhereUserId, findAll, deleteWhereUserId,
	 * 
	*/
	
	MessageResultDTO Create(AssignmentDTO info) throws Exception;
	MessageResultDTO deleteWhereUserId(UUID id) throws Exception;
	MessageResultDTO deleteOneWhereUserId(DeleteRolFromUserDTO info) throws Exception;
	UserAndRolDTO findAllWhereUserId(UUID id);
	List<UserAndRolDTO> findAll();
	
}
