package com.ticketya.ticketsweb.controllers.ticket;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowEventDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.ChangeOwnerDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.CreateQRDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.CreateTicketDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.SaveCategoryTicketDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.ShowQRDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.ShowTicketDTO;
import com.ticketya.ticketsweb.models.entities.ticket.Ticket;
import com.ticketya.ticketsweb.services.ticket.CategoryService;
import com.ticketya.ticketsweb.services.ticket.QRService;
import com.ticketya.ticketsweb.services.ticket.TicketService;
import com.ticketya.ticketsweb.utils.PageDTO;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ticket")
public class TicketController {
	
	//Importing the services to call the implementations
	
	@Autowired
	private TicketService ticketservice;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private QRService QRService;
	
	// Routes to Ticket

	@GetMapping("/all")
	public ResponseEntity<?> findAllTickets(){
		return new ResponseEntity<>(ticketservice.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/owner/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findTicketByIdOwner(@PathVariable UUID id) throws Exception{
		List<ShowTicketDTO> result = ticketservice.findAllWhereUserid(id);
		
		if (!result.isEmpty()) {
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		return new ResponseEntity<>("error, ticket no encontrado",HttpStatus.BAD_REQUEST);
	}
	
	//page owner
	@GetMapping("/owner/page")
	public ResponseEntity<?> findTicketByIdOwnerPage(
			@RequestHeader("Authorization") String token,
    		@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size){
        PageDTO<ShowTicketDTO> list = ticketservice.findAllWhereUseridpage(token, page, size);
        if (list == null) {
        	return new ResponseEntity<>("error en campos",HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
	
	@RequestMapping(value="/", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> CreateTicket(@RequestBody @Valid CreateTicketDTO createTicketDTO) throws Exception{
		MessageResultDTO myticket = ticketservice.save(createTicketDTO);
		switch (myticket.getMessage()) {
		case "ticket creado": {
			return new ResponseEntity<>(myticket.getMessage(),HttpStatus.OK);
		}
		case "nombre de usuario no disponible":{
			return new ResponseEntity<>("nombre de usuario no disponible",HttpStatus.BAD_REQUEST);
			
			}
		default:
			return new ResponseEntity<>("Los campos no son validos",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<?> ToggleTicketActive(@PathVariable UUID id) throws Exception{
		MessageResultDTO result = ticketservice.toggleActive(id);
		
		switch (result.getMessage()) {
		case "ticket cambiado a desactivado":
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		case "ticket cambiado a activo":
			return new ResponseEntity<>(result.getMessage(),HttpStatus.BAD_REQUEST);
		default:
			return new ResponseEntity<>("error en el id",HttpStatus.BAD_GATEWAY);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findTicketById(@PathVariable UUID id) throws Exception{
		ShowTicketDTO result = ticketservice.findOneByid(id);
		
		if (result != null) {
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		return new ResponseEntity<>("error, ticket no encontrado",HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/owner/", method = RequestMethod.PUT)
	public ResponseEntity<?> changeTicketOwner(@RequestBody ChangeOwnerDTO info) throws Exception{
		MessageResultDTO result = ticketservice.changeOwner(info);
		
		switch (result.getMessage()) {
		case "ticket ha cambiado de dueño":
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		case "error los campos no coinciden":
			return new ResponseEntity<>(result.getMessage(),HttpStatus.BAD_REQUEST);
		default:
			return new ResponseEntity<>("Error en campos",HttpStatus.BAD_GATEWAY);
		}
	}
	
	// entities related
	
	// category
	
	@GetMapping("/category/all")
	public ResponseEntity<?> findAllTicketCategory(){
		return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/category/", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> saveCategoryTicket(@RequestBody @Valid SaveCategoryTicketDTO saveCategoryTicketDTO) throws Exception{
		MessageResultDTO myticket = categoryService.create(saveCategoryTicketDTO);
		
		if (myticket.getMessage().equals("creado exitosamente")) {
			return new ResponseEntity<>(myticket.getMessage(),HttpStatus.OK);
		}
		return new ResponseEntity<>(myticket.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCategoryTicket(@PathVariable UUID id) throws Exception{
		MessageResultDTO result = categoryService.delete(id);
		if(result.getMessage().equals("borrado exitosamente")) {
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>("error en campos",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCategoryTicket(@RequestBody SaveCategoryTicketDTO saveCategoryTicketDTO,@PathVariable UUID id) throws Exception{
		MessageResultDTO result = categoryService.updatePrice(saveCategoryTicketDTO,id);
		if(result.getMessage().equals("categoria editada")) {
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	// QR
	
	@GetMapping("/QR/all")
	public ResponseEntity<?> findAllTicketQR(){
		return new ResponseEntity<>(QRService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/QR/{id}")
	public ResponseEntity<?> findQrByID(@PathVariable UUID id){
		ShowQRDTO result = QRService.findOneByTicket(id);
		if (result != null){
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>("error en id", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/QR/time/{id}")
	public ResponseEntity<?> findQrTimeByID(@PathVariable UUID id){
		return new ResponseEntity<>(QRService.findTimeByid(id), HttpStatus.OK);
	}
	
	@GetMapping("/QR/user/{id}")
	public ResponseEntity<?> findQrByUser(@PathVariable UUID id){
		List<ShowQRDTO> result = QRService.findAllByUser(id);
		if (!result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>("lista vacia o error en usuario", HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value="/QR/", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> saveQRTIcket(@RequestBody @Valid CreateQRDTO createQRDTO) throws Exception{
		MessageResultDTO myticket = QRService.create(createQRDTO);
		
		if (myticket.getMessage().equals("creado exitosamente")) {
			return new ResponseEntity<>(myticket.getMessage(),HttpStatus.OK);
		}
		return new ResponseEntity<>(myticket.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/QR/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> saveQRTIcket(@PathVariable UUID id) throws Exception{
		MessageResultDTO myticket = QRService.delete(id);
		
		if (myticket.getMessage().equals("borrado exitosamente")) {
			return new ResponseEntity<>(myticket.getMessage(),HttpStatus.OK);
		}
		return new ResponseEntity<>(myticket.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
