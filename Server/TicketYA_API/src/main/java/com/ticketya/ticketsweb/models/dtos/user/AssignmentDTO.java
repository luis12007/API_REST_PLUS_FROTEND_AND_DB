package com.ticketya.ticketsweb.models.dtos.user;


import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AssignmentDTO {
	
	private UUID rol;

	private UUID user;
}
