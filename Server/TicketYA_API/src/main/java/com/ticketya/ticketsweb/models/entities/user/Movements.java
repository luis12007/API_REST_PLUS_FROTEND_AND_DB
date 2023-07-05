package com.ticketya.ticketsweb.models.entities.user;

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
@Table(name = "movimientos")
public class Movements {
	@Id
	@Column(name = "id_movimiento")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_movement;
	
	@Column(name = "movimiento")
	private String movement;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", nullable = true)
	private User user_mov;
	
	@Column(name = "descripcion")
	private String descrip;

	public Movements(String movement, User user_mov,String descrip) {
		super();
		this.movement = movement;
		this.user_mov = user_mov;
		this.descrip = descrip;
	}

	
	
}
