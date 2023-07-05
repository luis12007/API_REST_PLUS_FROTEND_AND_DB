package com.ticketya.ticketsweb.models.dtos.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequestDTO {

    private String from;
    private String to;
    private String subject;
    private String body;
    
}
