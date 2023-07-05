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
@ToString(exclude = {"events"})
@Table(name = "categoria_evento")
public class CategoryEvent {
	@Id
	@Column(name = "id_categoria")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_category;
	
	@Column(name = "nombre")
	private String name;
	
	//sintaxis of fk
	
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Event> events;
	

	public CategoryEvent(String name) {
		super();
		this.name = name;
	}
}
