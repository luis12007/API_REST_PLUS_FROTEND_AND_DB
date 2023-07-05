package com.ticketya.ticketsweb.models.dtos.user;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShowUserDTO {

	private UUID userid;
	
	private String username;
	
	private String mail;
	
	private Boolean authentication;
}
