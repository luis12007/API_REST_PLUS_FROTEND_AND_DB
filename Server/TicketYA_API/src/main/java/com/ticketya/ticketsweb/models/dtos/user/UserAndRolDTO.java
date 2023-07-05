package com.ticketya.ticketsweb.models.dtos.user;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAndRolDTO {

	private String identifier;
	
	private List<String> Rol;
}
