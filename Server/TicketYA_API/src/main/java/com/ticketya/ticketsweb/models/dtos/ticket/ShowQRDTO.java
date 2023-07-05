package com.ticketya.ticketsweb.models.dtos.ticket;


import java.sql.Timestamp;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.user.ShowUserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShowQRDTO {
	
	private UUID id;
	
	private Timestamp time;
	
	private String code;
	
	private ShowUserDTO user;

}
