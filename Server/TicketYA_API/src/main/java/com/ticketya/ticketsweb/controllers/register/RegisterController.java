package com.ticketya.ticketsweb.controllers.register;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.AdministrationDTO;
import com.ticketya.ticketsweb.models.dtos.event.CreateEventDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowAdministrationDTO;
import com.ticketya.ticketsweb.services.events.AdministrationService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/register")
public class RegisterController {
	
	//Importing the services to call the implementations
	
	@Autowired
	private AdministrationService admiService;
	
	//Routes to Register Logic
	
	@GetMapping("/all")
	public ResponseEntity<?> findalluser(){
		List<ShowAdministrationDTO> result = admiService.findAll();
		if (!result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>("lista vacia",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/event/{id}")
	public ResponseEntity<?> findEventById(@PathVariable UUID id){
		List<ShowAdministrationDTO> result = admiService.findAttendanceWhereEvent(id);
		if (!result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>("error en id", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/group/{group}")
	public ResponseEntity<?> findEventById(@PathVariable String group){
		List<ShowAdministrationDTO> result = admiService.findAttendanceWhereGeneral(group);
		if (!result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>("error en el grupo", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> createAdministration(@RequestBody AdministrationDTO info) throws Exception{
		MessageResultDTO resultMov = admiService.save(info);
		
		if (resultMov.getMessage().equals("creado exitosamente")) {
			return new ResponseEntity<>(resultMov.getMessage(),HttpStatus.OK);
		}
	return new ResponseEntity<>(resultMov.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
}
