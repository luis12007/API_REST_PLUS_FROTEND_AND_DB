package com.ticketya.ticketsweb.repositories.event;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.ticketya.ticketsweb.models.dtos.event.CreateEventDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowEventDTO;
import com.ticketya.ticketsweb.models.entities.event.Event;

public interface EventRespository extends JpaRepository<Event, UUID>{

	List<Event> findAll();
	
	Page<Event> findAllByTittleContains(String title,Pageable pageable);
	
	
	@Query("SELECT e FROM Event e WHERE e.category.name = :namecatego")
    Page<Event> findByCategoryName(@Param("namecatego") String namecatego, Pageable pageable);
}
