package com.ticketya.ticketsweb.controllers.event;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.CreateEventDTO;
import com.ticketya.ticketsweb.models.dtos.event.CreateLocationDTO;
import com.ticketya.ticketsweb.models.dtos.event.SaveCategoryEventDTO;
import com.ticketya.ticketsweb.models.dtos.event.SaveCollaboratorDTO;
import com.ticketya.ticketsweb.models.dtos.event.SaveSponsorDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowEventDTO;
import com.ticketya.ticketsweb.models.dtos.user.SaveMovementsDTO;
import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.models.entities.event.Location;
import com.ticketya.ticketsweb.models.entities.event.Sponsor;
import com.ticketya.ticketsweb.services.events.CategoryService;
import com.ticketya.ticketsweb.services.events.CollaboratorService;
import com.ticketya.ticketsweb.services.events.EventService;
import com.ticketya.ticketsweb.services.events.LocationService;
import com.ticketya.ticketsweb.services.events.SponsorService;
import com.ticketya.ticketsweb.utils.PageDTO;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/event")
public class EventController {
	
	//Importing the services to call the implementations

	@Autowired
	private EventService eventService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private SponsorService sponsorService;
	
	@Autowired
	private CollaboratorService CollabService;
	
	@Autowired
	private CategoryService categoEventService;
	
	// Routes for event entitie
	
	@GetMapping("/all/category/page")
	public ResponseEntity<?> findallEventByCategoryPage(@RequestParam(defaultValue = "") String cat,
    		@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size){
        PageDTO<ShowEventDTO> list = eventService.findEventsByCategory(cat, page, size);
        if (list == null) {
        	return new ResponseEntity<>("error en campos",HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
	
	@GetMapping("/all/title/page")
	public ResponseEntity<?> findallEventByTitlePage(@RequestParam(defaultValue = "") String title,
    		@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size){
		System.out.println(title);
        PageDTO<ShowEventDTO> list = eventService.findEventsByName(title, page, size);
        System.out.println(list);
        if (list == null) {
        	return new ResponseEntity<>("error en campos",HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
	
	@GetMapping("/all")
	public ResponseEntity<?> findallEvent(){
		return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findEventById(@PathVariable UUID id){
		Event events = eventService.findOneById(id);
		if (events != null) {
			return new ResponseEntity<>(events,HttpStatus.OK);
		}
		return new ResponseEntity<>("error en id",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<?> findEventCategoryById(@PathVariable UUID id){
			List<Event> events = eventService.FindByCategory(id);
			if (!events.isEmpty()) {
				return new ResponseEntity<>(events,HttpStatus.OK);
			}
			return new ResponseEntity<>("error en id",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> createEvent(@RequestBody @Valid CreateEventDTO info, BindingResult result) throws Exception{
		MessageResultDTO resultMov = eventService.save(info);
		
		if (resultMov.getMessage().equals("guardado exitosamente")) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>(resultMov,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/state/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<?> toggleStateEvent(@PathVariable UUID id) throws Exception{
			MessageResultDTO result = eventService.toogleState(id);
		if (result.getMessage().equals("estado cambiado a false")
				|| result.getMessage().equals("estado cambiado a true")) {
			return new ResponseEntity<>(result.getMessage(), HttpStatus.OK);
		}
		return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/panic/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<?> toggleEventPanic(@PathVariable UUID id) throws Exception{
			MessageResultDTO result = eventService.togglePanic(id);
		if (result.getMessage().equals("evento desactivado (emergencia)")
				|| result.getMessage().equals("evento reactivado")) {
			return new ResponseEntity<>(result.getMessage(), HttpStatus.OK);
		}
		return new ResponseEntity<>(result.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	// Tables related to event
	
	// Location
	
	@GetMapping("/location/all")
	public ResponseEntity<?> finAllEventLocation(){
		return new ResponseEntity<>(locationService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/location/{id}")
	public ResponseEntity<?> findEventLocationById(@PathVariable UUID id) throws Exception{
		List<Location> result = locationService.findAllWhereEvent(id);
		if(!result.isEmpty()) {
			return new ResponseEntity<>(result,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("error en id",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/location/")
	public ResponseEntity<?> createEventLocation(@RequestBody @Valid CreateLocationDTO info, BindingResult result) throws Exception{
		MessageResultDTO resultMov = locationService.save(info);
		
		if (resultMov.getMessage().equals("creado exitosamente")) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>(resultMov,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/location/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEventLocation(@PathVariable UUID id) throws Exception{
		MessageResultDTO result = locationService.delete(id);
		if(result.getMessage().equals("borrado exitosamente")) {
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>("error en campos",HttpStatus.BAD_REQUEST);
		}
	}
	
	// Sponsor
	
	@GetMapping("/sponsor/all")
	public ResponseEntity<?> finAllEventSponsor(){
		return new ResponseEntity<>(sponsorService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/sponsor/{id}")
	public ResponseEntity<?> findEventSponsorById(@PathVariable UUID id) throws Exception{
		List<Sponsor> result = sponsorService.findAllWhereEvent(id);
		if(!result.isEmpty()) {
			return new ResponseEntity<>(result,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("error en id",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/sponsor/")
	public ResponseEntity<?> createEventSponsor(@RequestBody @Valid SaveSponsorDTO info, BindingResult result) throws Exception{
		MessageResultDTO resultMov = sponsorService.save(info);
		
		if (resultMov.getMessage().equals("creado exitosamente")) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>(resultMov,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/sponsor/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEventSponsor(@PathVariable UUID id) throws Exception{
		MessageResultDTO result = sponsorService.delete(id);
		if(result.getMessage().equals("borrado exitosamente")) {
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>("error en campos",HttpStatus.BAD_REQUEST);
		}
	}
	
	// Collaborator
	
	@GetMapping("/collaborator/all")
	public ResponseEntity<?> finAllEventCollaborator(){
		return new ResponseEntity<>(CollabService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/collaborator/")
	public ResponseEntity<?> createEventCollaborator(@RequestBody @Valid SaveCollaboratorDTO info, BindingResult result) throws Exception{
		MessageResultDTO resultMov = CollabService.save(info);
		
		if (resultMov.getMessage().equals("creado exitosamente")) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>(resultMov,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/collaborator/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEventCollaborator(@PathVariable UUID id) throws Exception{
		MessageResultDTO result = CollabService.delete(id);
		if(result.getMessage().equals("borrado exitosamente")) {
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	// Category
	
	@GetMapping("/category/all")
	public ResponseEntity<?> finAllEventCategory(){
		return new ResponseEntity<>(categoEventService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/category/")
	public ResponseEntity<?> createEventCategory(@RequestBody @Valid SaveCategoryEventDTO info, BindingResult result) throws Exception{
		MessageResultDTO resultMov = categoEventService.save(info);
		
		if (resultMov.getMessage().equals("creado exitosamente")) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>(resultMov,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEventCategory(@PathVariable UUID id) throws Exception{
		MessageResultDTO result = categoEventService.delete(id);
		if(result.getMessage().equals("borrado exitosamente")) {
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
}
