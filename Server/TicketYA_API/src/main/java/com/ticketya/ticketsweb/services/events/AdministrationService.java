package com.ticketya.ticketsweb.services.events;

import java.util.List;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.AdministrationDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowAdministrationDTO;
import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.models.entities.event.fks.Administration;
import com.ticketya.ticketsweb.models.entities.user.User;

public interface AdministrationService {
	/*
	 * Save, delete, findOrderByGroup, findAttendanceWhereEvent,findAttendanceWhereGeneral
	*/
	
	List<ShowAdministrationDTO> findAll();
	MessageResultDTO save(AdministrationDTO info);
	List<ShowAdministrationDTO> findAttendanceWhereEvent(UUID id);
	List<ShowAdministrationDTO> findAttendanceWhereGeneral(String group);
}
