package com.ticketya.ticketsweb.models.entities.user.fks;

import java.util.UUID;

import com.ticketya.ticketsweb.models.entities.user.Rols;
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
@Table(name = "asignacion")
public class Assignment {
	@Id
	@Column(name = "id_asignacion")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_assignment;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rol", nullable = true)
	private Rols rol;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", nullable = true)
	private User assiguser;

	public Assignment(Rols rol, User assiguser) {
		super();
		this.rol = rol;
		this.assiguser = assiguser;
	}

}
