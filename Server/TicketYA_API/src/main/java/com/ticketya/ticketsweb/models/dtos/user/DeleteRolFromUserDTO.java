package com.ticketya.ticketsweb.models.dtos.user;

import java.util.UUID;

import lombok.Data;

@Data
public class DeleteRolFromUserDTO {

	private UUID user;
	
	private String rol;
}
