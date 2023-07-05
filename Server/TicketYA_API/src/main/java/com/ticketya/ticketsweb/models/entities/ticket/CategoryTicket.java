package com.ticketya.ticketsweb.models.entities.ticket;

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
@ToString(exclude = {"tickets_cat"})
@Table(name = "categoria_ticket")
public class CategoryTicket {
		
		@Id
		@Column(name = "id_categoria")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private UUID id_category;
		
		@Column(name = "precio")
		private Float price;
		
		@Column(name = "capacidad_maxima")
		private Integer capacity;
		
		//sintaxis of fk
		
		@OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
		@JsonIgnore
		private List<Ticket> tickets_cat;
		
		public CategoryTicket(Float price, Integer capacity) {
			super();
			this.price = price;
			this.capacity = capacity;
		}
}
