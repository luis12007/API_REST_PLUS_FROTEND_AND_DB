package com.ticketya.ticketsweb.repositories.ticket;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.ticketya.ticketsweb.models.dtos.ticket.CreateTicketDTO;

import com.ticketya.ticketsweb.models.entities.ticket.Ticket;


public interface TicketReposotiry extends JpaRepository<Ticket, UUID>{
	// Empty because the JpaRepository has already the basic CRUD
	
	@Query("SELECT t FROM Ticket t WHERE t.owner = :owner")
    Page<Ticket> findAllByOwner(@Param("owner") UUID owner, Pageable pageable);
	
	
}
