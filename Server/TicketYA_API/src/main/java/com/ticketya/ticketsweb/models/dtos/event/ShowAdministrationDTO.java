package com.ticketya.ticketsweb.models.dtos.event;

import java.util.Date;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.user.ShowUserDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowEventDTO;
import lombok.Data;

@Data
public class ShowAdministrationDTO {

	private UUID id;
	
	private ShowEventDTO showEventDTO;
	
	private ShowUserDTO user;
	
	private Date date;
	
	private String group;

	private Boolean attendance;
	
	public ShowAdministrationDTO(UUID id,  ShowEventDTO showEventDTO,
			ShowUserDTO user, Date date, String group, Boolean attendance) {
		super();
		this.id = id;
		this.showEventDTO = showEventDTO;
		this.user = user;
		this.date = date;
		this.group = group;
		this.attendance = attendance;
	}
}
