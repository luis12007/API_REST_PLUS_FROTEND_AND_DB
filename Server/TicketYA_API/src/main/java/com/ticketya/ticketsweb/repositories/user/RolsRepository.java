package com.ticketya.ticketsweb.repositories.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import com.ticketya.ticketsweb.models.entities.user.Rols;

public interface RolsRepository extends JpaRepository<Rols, UUID> {
	Optional<Rols> findById(UUID id);
}
