package com.ticketya.ticketsweb.models.dtos.ticket;

import java.util.UUID;

import com.ticketya.ticketsweb.models.entities.user.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateTicketDTO {
	
	@NotEmpty
	private String tier;
	
	private UUID user;
	
	private UUID owner;

	private Boolean active;
	
	private UUID event;
	
	private UUID qr;
		
	private UUID category;
	
}
