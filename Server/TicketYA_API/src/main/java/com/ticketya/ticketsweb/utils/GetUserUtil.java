package com.ticketya.ticketsweb.utils;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ticketya.ticketsweb.models.entities.user.User;
import com.ticketya.ticketsweb.repositories.user.UserRespository;

@Component
public class GetUserUtil {
	
	//importing the repository
	
	@Autowired
	private UserRespository userrepo;
	
	//function to find user y id, get one user in specific
	
	public User findUserById(UUID id){
		User user = userrepo.findById(id).orElse(null);
		return user;
	}

}
