package com.ticketya.ticketsweb.controllers.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketya.ticketsweb.models.dtos.mail.EmailRequestDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private JavaMailSender javamailsender;
	
    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequestDTO emailRequest) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailRequest.getFrom());
            message.setTo(emailRequest.getTo());
            message.setSubject(emailRequest.getSubject());
            message.setText(emailRequest.getBody());
            System.out.println(message);
            javamailsender.send(message);

            return new ResponseEntity<>("Correo electronico enviado",HttpStatus.OK);

    }
}