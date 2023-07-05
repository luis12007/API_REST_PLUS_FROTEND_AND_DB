package com.ticketya.ticketsweb.models.dtos.ticket;

import java.sql.Timestamp;
import java.util.UUID;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateQRDTO {


	private Timestamp time;
	
	@NotEmpty
	private String code;

	private UUID user;
	
	
}
