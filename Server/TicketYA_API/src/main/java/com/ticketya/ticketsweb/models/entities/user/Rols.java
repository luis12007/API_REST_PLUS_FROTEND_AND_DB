package com.ticketya.ticketsweb.models.entities.user;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ticketya.ticketsweb.models.entities.user.fks.Assignment;

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
@ToString(exclude = {"rols"})
@Table(name = "roles")
public class Rols {
	@Id
	@Column(name = "id_rol")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_rol;
	
	@Column(name = "nombre")
	private String name;
	
	//FK sintax
	@OneToMany(mappedBy = "rol",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Assignment> rols;

	public Rols(String name) {
		super();
		this.name = name;
	}

}
