package com.ticketya.ticketsweb.repositories.user;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketya.ticketsweb.models.entities.user.Token;
import com.ticketya.ticketsweb.models.entities.user.User;

public interface TokenRepository extends JpaRepository<Token, UUID> {

	List<Token> findByUserAndActive(User user, Boolean active);
}
