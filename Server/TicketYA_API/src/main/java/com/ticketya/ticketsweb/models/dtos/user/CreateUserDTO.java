package com.ticketya.ticketsweb.models.dtos.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateUserDTO {

	private Boolean authentication;

	@NotEmpty
	private String username;

	private String password;

	@NotEmpty
	@Email
	private String mail;
	
	private Boolean active;
	
}
