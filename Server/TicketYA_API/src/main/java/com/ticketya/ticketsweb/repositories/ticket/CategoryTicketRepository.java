package com.ticketya.ticketsweb.repositories.ticket;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import com.ticketya.ticketsweb.models.entities.ticket.CategoryTicket;

public interface CategoryTicketRepository extends JpaRepository<CategoryTicket, UUID>{
	// Empty because the ListCrudRepository has already the basic CRUD
}
