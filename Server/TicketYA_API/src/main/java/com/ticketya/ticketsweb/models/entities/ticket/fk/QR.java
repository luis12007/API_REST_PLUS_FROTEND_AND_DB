package com.ticketya.ticketsweb.models.entities.ticket.fk;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ticketya.ticketsweb.models.entities.ticket.Ticket;
import com.ticketya.ticketsweb.models.entities.user.User;

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
@ToString(exclude = {"tickets"})
@Table(name = "qr")
public class QR {
	@Id
	@Column(name = "id_qr")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_qr;
	
	@Column(name = "tiempo_validacion")
	private Timestamp time;
	
	@Column(name = "codigo_hash")
	private String code;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", nullable = true)
	private User userqr;

	//TODO: one to manytoone sintaxis of fk
	
	@OneToMany(mappedBy = "qr", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Ticket> tickets;

	public QR(Timestamp time, String code, User userqr) {
		super();
		this.time = time;
		this.code = code;
		this.userqr = userqr;
	}

	
	
}
