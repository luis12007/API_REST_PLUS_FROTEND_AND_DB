package com.ticketya.ticketsweb.repositories.ticket;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import com.ticketya.ticketsweb.models.entities.ticket.fk.QR;

public interface QRepository extends JpaRepository<QR, UUID> {
	// Empty because the ListCrudRepository has already the basic CRUD
}
