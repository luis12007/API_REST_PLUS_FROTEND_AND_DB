package com.ticketya.ticketsweb.models.entities.event.fks;

import java.sql.Timestamp;
import java.util.UUID;

import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.models.entities.user.User;

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
@Table(name = "administracion")
public class Administration {
	@Id
	@Column(name = "id_asistencia")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_administration;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_evento", nullable = true)
	private Event eventadmi;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente", nullable = true)
	private User useradmi;
	
	@Column(name = "fecha")
	private Timestamp date;
	
	@Column(name = "grupo")
	private String group;
	
	@Column(name = "asistencia")
	private Boolean attendance;

	public Administration(Event eventadmi, User useradmi, Timestamp date, String group, Boolean attendance) {
		super();
		this.eventadmi = eventadmi;
		this.useradmi = useradmi;
		this.date = date;
		this.group = group;
		this.attendance = attendance;
	}
	
	
	
	
	
}
