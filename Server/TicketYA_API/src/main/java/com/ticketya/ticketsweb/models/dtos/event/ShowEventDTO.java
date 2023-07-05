package com.ticketya.ticketsweb.models.dtos.event;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShowEventDTO {

	private UUID id;
	
	private String title;
	
	private Date date;
	
	private Time hour;
	
	private String image;
	
	private Integer duration;
}
