package com.ticketya.ticketsweb.models.dtos.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfSingInDTO {
	@NotEmpty
    private String username;
	
	@NotEmpty
    private String mail;
	
	@NotEmpty
    private Boolean active;
}
