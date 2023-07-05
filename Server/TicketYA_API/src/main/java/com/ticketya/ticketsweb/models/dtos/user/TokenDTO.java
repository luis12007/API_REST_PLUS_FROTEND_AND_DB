package com.ticketya.ticketsweb.models.dtos.user;


import com.ticketya.ticketsweb.models.entities.user.Token;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO {

	private String token;
	
	public TokenDTO(Token token) {
		this.token = token.getContent();
	}
	
}
