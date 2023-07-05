package com.ticketya.ticketsweb.models.entities.event;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = {"events_col"})
@Table(name = "colaborador")
public class Collaborator {
	@Id
	@Column(name = "id_colaborador")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_event;
	
	@Column(name = "nombre")
	private String name;
	
	//sintaxis of fk
	
	@OneToMany(mappedBy = "collaborator",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Event> events_col;

	public Collaborator(String name) {
		super();
		this.name = name;
	}
}
