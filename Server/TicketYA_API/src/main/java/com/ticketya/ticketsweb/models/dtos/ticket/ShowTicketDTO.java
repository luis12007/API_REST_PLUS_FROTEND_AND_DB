package com.ticketya.ticketsweb.models.dtos.ticket;

import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.event.ShowEventDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowUserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShowTicketDTO {

	private UUID id;
	
	private String tier;
	
	private UUID owner;
	
	private Boolean active;
	
	private ShowUserDTO user;
	
	private ShowEventDTO event;
	
	private ShowQRDTO qr;
}
