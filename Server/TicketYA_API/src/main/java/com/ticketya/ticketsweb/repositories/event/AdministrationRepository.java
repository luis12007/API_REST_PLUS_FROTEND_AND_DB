package com.ticketya.ticketsweb.repositories.event;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.ticketya.ticketsweb.models.entities.event.fks.Administration;

public interface AdministrationRepository extends ListCrudRepository<Administration, UUID> {
	// Empty because the ListCrudRepository has already the basic CRUD	
}
