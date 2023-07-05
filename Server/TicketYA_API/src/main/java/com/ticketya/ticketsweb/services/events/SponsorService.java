package com.ticketya.ticketsweb.services.events;

import java.util.List;
import java.util.UUID;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.SaveSponsorDTO;
import com.ticketya.ticketsweb.models.entities.event.Sponsor;

public interface SponsorService {
	/*
	 * Save, delete, findOrderByGroup, findAll, findAllWhereEvent
	*/
	MessageResultDTO save(SaveSponsorDTO info) throws Exception;
	List<Sponsor> findAll();
	MessageResultDTO delete(UUID id) throws Exception;
	List<Sponsor> findAllWhereEvent(UUID id);
}
