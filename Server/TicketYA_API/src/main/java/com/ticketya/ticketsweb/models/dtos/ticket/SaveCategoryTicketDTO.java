package com.ticketya.ticketsweb.models.dtos.ticket;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SaveCategoryTicketDTO {
	private Float price;

	private Integer capacity;
}
