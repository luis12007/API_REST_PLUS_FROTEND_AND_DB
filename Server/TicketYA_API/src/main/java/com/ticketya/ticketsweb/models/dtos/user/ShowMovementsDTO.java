package com.ticketya.ticketsweb.models.dtos.user;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShowMovementsDTO {

	private UUID id;
	
	private String movement;
	
	private String descrip;
	
	private ShowUserDTO user;
}
