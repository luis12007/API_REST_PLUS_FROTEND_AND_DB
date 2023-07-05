package com.ticketya.ticketsweb.repositories.event;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.ticketya.ticketsweb.models.entities.event.Location;

public interface LocationRepository extends ListCrudRepository<Location, UUID> {
	// Empty because the ListCrudRepository has already the basic CRUD
}
