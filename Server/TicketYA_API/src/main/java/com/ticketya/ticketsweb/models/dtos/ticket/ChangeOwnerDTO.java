package com.ticketya.ticketsweb.models.dtos.ticket;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ChangeOwnerDTO {
	@NotEmpty
	private String hash;
	
	private UUID userowner;
	
	private UUID newowner;

}
