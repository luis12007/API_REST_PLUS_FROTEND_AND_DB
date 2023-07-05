package com.ticketya.ticketsweb.models.dtos.event;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SaveCategoryEventDTO {

	@NotEmpty
	private String name;
}
