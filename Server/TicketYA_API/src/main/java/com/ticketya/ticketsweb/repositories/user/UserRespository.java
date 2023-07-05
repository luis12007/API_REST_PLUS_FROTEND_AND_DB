package com.ticketya.ticketsweb.repositories.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;


import com.ticketya.ticketsweb.models.dtos.user.CreateUserDTO;

import com.ticketya.ticketsweb.models.entities.user.User;

public interface UserRespository extends JpaRepository<User, UUID> {

	CreateUserDTO save(CreateUserDTO entity);
	List<User> findAll();
	void deleteById(UUID id);
	Optional<User> findById(UUID id);
	User findByUsername(String username);
	User findByUsernameContains(String Username);
}
