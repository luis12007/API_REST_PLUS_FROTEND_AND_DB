package com.ticketya.ticketsweb.models.dtos.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserSignInDTO {

    @NotEmpty(message = "el campo del nombre no debe ir vacío. ")
    private String identifier;
    
    private String password;

}
