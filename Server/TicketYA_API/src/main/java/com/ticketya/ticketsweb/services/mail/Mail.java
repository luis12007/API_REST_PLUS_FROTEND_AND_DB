package com.ticketya.ticketsweb.services.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Mail {
	
	private final JavaMailSender mailSender;

    @Autowired
    public Mail(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarCorreo(String direccionCorreo, String asunto, String mensaje) {
        SimpleMailMessage correo = new SimpleMailMessage();
        correo.setTo(direccionCorreo);
        correo.setSubject(asunto);
        correo.setText(mensaje);

        mailSender.send(correo);
    }
}
