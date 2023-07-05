package com.ticketya.ticketsweb.models.entities.event;

import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "localidad")
public class Location {
	@Id
	@Column(name = "id_localidad")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID location;
	
	@Column(name = "rating")
	private String rating;
	
	@Column(name = "nombre")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_evento", nullable = true)
	private Event eventlocation;

	public Location(String rating, String name, Event eventlocation) {
		super();
		this.rating = rating;
		this.name = name;
		this.eventlocation = eventlocation;
	}
	
	
}
