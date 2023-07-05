package com.ticketya.ticketsweb.models.dtos.event;

import java.sql.Timestamp;
import java.util.UUID;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AdministrationDTO {

	private UUID event;
	
	private UUID user;
	
	private Timestamp date;
	
	@NotEmpty
	private String group;
	
	private Boolean attendance;
}
