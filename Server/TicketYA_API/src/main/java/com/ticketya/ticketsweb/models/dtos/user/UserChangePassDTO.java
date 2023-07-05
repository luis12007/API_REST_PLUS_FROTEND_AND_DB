package com.ticketya.ticketsweb.models.dtos.user;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserChangePassDTO {
	@NotBlank(message = "el campo del identificador del usuario no debe ir nulo o vacío")@Size(min=8,max=8,message = "el campo del identificador del usuario no debe ir nulo o vacío y el formato aceptado es el siguiente: (@@######)")
	private UUID id_user;
	
	@NotEmpty(message = "el campo de la contraseña del usuario no debe ir vacía")
	private String password;
	@NotEmpty(message = "el campo del correo no debe ir nulo o vacío")
	private String PassNew;
}
