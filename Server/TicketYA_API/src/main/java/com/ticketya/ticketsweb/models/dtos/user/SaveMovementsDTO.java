package com.ticketya.ticketsweb.models.dtos.user;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SaveMovementsDTO {

	@NotEmpty
	private String movement;
	
	private String descrip;
}
