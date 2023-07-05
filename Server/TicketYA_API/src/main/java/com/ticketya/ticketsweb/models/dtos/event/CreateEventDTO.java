package com.ticketya.ticketsweb.models.dtos.event;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateEventDTO {
	
	@NotEmpty
	private String tittle;
	
	private Date date;
	
	private Time hour;
	
	private UUID category;
	
	private UUID collaborator;
	
	@NotEmpty
	private String image;
	
	private Integer duration;

	private Boolean panic;

	private Boolean estado;
	
}
