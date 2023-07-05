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
@Table(name = "patrocinador")
public class Sponsor {

	@Id
	@Column(name = "id_patrocinador")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID sponsor;

	@Column(name = "nombre")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_evento", nullable = true)
	private Event eventsponsor;
	
	
		public Sponsor(String name, Event eventsponsor) {
			super();
			this.name = name;
			this.eventsponsor = eventsponsor;
		}
	

	
}
