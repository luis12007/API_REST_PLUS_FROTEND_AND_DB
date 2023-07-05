package com.ticketya.ticketsweb.models.entities.ticket;

import java.util.UUID;

import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.models.entities.ticket.fk.QR;
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
@Table(name = "ticket")
public class Ticket {
		@Id
		@Column(name = "id_ticket")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private UUID id_ticket;

		@Column(name = "tier")
		private String tier;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "id_usuario", nullable = true)
		private User user;
		
		@Column(name = "id_dueño")
		private UUID owner;

		@Column(name = "activo")
		private Boolean active;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "id_evento", nullable = true)
		private Event eventticket;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "id_qr", nullable = true)
		private QR qr;

		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "id_categoria", nullable = true)
		private CategoryTicket category;

		public Ticket(String tier, User user, UUID owner, Boolean active, Event eventticket, QR qr,
				CategoryTicket category) {
			super();
			this.tier = tier;
			this.user = user;
			this.owner = owner;
			this.active = active;
			this.eventticket = eventticket;
			this.qr = qr;
			this.category = category;
		}

		

		
		
}
