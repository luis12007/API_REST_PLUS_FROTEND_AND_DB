package com.ticketya.ticketsweb.models.dtos.event;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SaveCollaboratorDTO {

	@NotEmpty
	private String name;
}
