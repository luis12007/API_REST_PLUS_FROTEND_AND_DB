package com.ticketya.ticketsweb.repositories.user;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import com.ticketya.ticketsweb.models.entities.user.Movements;

public interface MovementsRepository extends JpaRepository<Movements, UUID>{
	// Empty because the ListCrudRepository has already the basic CRUD
}
