package com.ticketya.ticketsweb.services.user;

import java.util.List;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.user.CreateUserDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowUserDTO;
import com.ticketya.ticketsweb.models.dtos.user.UserInfSingInDTO;
import com.ticketya.ticketsweb.models.dtos.user.UserSignInDTO;
import com.ticketya.ticketsweb.models.entities.user.Token;
import com.ticketya.ticketsweb.models.entities.user.User;
import com.ticketya.ticketsweb.utils.PageDTO;

public interface UserService {
	/*
	 * Create, ToggleActive, findOneById, findAll, ChangePass, Singin
	*/
	
	MessageResultDTO save(CreateUserDTO info) throws Exception;
	MessageResultDTO deleteById(UUID id) throws Exception;
	List<ShowUserDTO> findAll();
	ShowUserDTO findOneById(UUID id);	
	MessageResultDTO toggleAuthById(UUID id) throws Exception;
	MessageResultDTO toggleActiveById(UUID id) throws Exception;
	User logIn(UserSignInDTO userSignInDTO);
	
	
	User findByusername(String username);
	//Token management
	Token registerToken(User user) throws Exception;
	Boolean isTokenValid(User user, String token);
	void cleanTokens(User user) throws Exception;
	
	//pagination
	PageDTO<ShowUserDTO> findAll(int page, int size);
	
	//owami
	ShowUserDTO findOneByToken(String token);	
}
