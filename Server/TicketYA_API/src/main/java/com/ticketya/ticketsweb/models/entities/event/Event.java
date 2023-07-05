package com.ticketya.ticketsweb.models.entities.event;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ticketya.ticketsweb.models.entities.event.fks.Administration;
import com.ticketya.ticketsweb.models.entities.ticket.Ticket;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = {"tickets","administration","location","sponsor"})
@Table(name = "evento")
public class Event {
	@Id
	@Column(name = "id_evento")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_event;
	
	@Column(name = "titulo")
	private String tittle;
	
	@Column(name = "fecha")
	private Date date;
	
	@Column(name = "hora")
	private Time hour;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_categoria", nullable = true)
	private CategoryEvent category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_colaborador", nullable = true)
	private Collaborator collaborator;
	
	@Column(name = "imagen")
	private String image;
	
	@Column(name = "duracion")
	private Integer duration;
	
	@Column(name = "boton_panico")
	private Boolean panic;
	
	@Column(name = "estado_venta")
	private Boolean estado;

	//FKS
	@OneToMany(mappedBy = "eventticket",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Ticket> tickets;
	
	@OneToMany(mappedBy = "eventadmi", fetch =FetchType.LAZY)
	@JsonIgnore
	private List<Administration> administration;
	
	@OneToMany(mappedBy = "eventlocation", fetch =FetchType.LAZY)
	@JsonIgnore
	private List<Location> location;
	
	@OneToMany(mappedBy = "eventsponsor", fetch =FetchType.LAZY)
	@JsonIgnore
	private List<Sponsor> sponsor;

	public Event(String tittle, Date date, Time hour, CategoryEvent category, Collaborator collaborator, String image,
			Integer duration, Boolean panic, Boolean estado) {
		super();
		this.tittle = tittle;
		this.date = date;
		this.hour = hour;
		this.category = category;
		this.collaborator = collaborator;
		this.image = image;
		this.duration = duration;
		this.panic = panic;
		this.estado = estado;
	}
	
	
	
}
