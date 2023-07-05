package com.ticketya.ticketsweb.controllers.user;

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
import com.ticketya.ticketsweb.models.dtos.user.AssignmentDTO;
import com.ticketya.ticketsweb.models.dtos.user.CreateUserDTO;
import com.ticketya.ticketsweb.models.dtos.user.DeleteRolFromUserDTO;
import com.ticketya.ticketsweb.models.dtos.user.SaveMovementsDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowMovementsDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowUserDTO;
import com.ticketya.ticketsweb.models.dtos.user.TokenDTO;
import com.ticketya.ticketsweb.models.dtos.user.UserAndRolDTO;
import com.ticketya.ticketsweb.models.dtos.user.UserInfSingInDTO;
import com.ticketya.ticketsweb.models.dtos.user.UserSignInDTO;
import com.ticketya.ticketsweb.models.entities.user.Movements;
import com.ticketya.ticketsweb.models.entities.user.Token;
import com.ticketya.ticketsweb.models.entities.user.User;
import com.ticketya.ticketsweb.services.user.AssignmentService;
import com.ticketya.ticketsweb.services.user.MovementsService;
import com.ticketya.ticketsweb.services.user.UserService;
import com.ticketya.ticketsweb.utils.PageDTO;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
	
	//Importing the services to call the implementations

	@Autowired
	private UserService userservice;
	
	@Autowired
	private MovementsService movementservice;
	
	@Autowired
	private AssignmentService assigService;
	
	// Routes to User entiite
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllUser(){
		return new ResponseEntity<>(userservice.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/all/page")
	public ResponseEntity<?> FindAllUsersByPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size){
		PageDTO<ShowUserDTO> user = userservice.findAll(page, size);
		if (user != null) {
			return new ResponseEntity<>(user,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("usuarios no encontrados",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> FindUserById(@PathVariable UUID id){
		ShowUserDTO user = userservice.findOneById(id);
		if (user != null) {
			return new ResponseEntity<>(user,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("usuario no encontrado",HttpStatus.NOT_FOUND);
		}
	}
	
	//user by token
	@GetMapping("/owami")
	public ResponseEntity<?> FindUserBytoken(@RequestHeader("Authorization") String token){
		ShowUserDTO user = userservice.findOneByToken(token);
		if (user != null) {
			return new ResponseEntity<>(user,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("usuario no encontrado",HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/auth/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> CreateUser(@RequestBody @Valid CreateUserDTO createUserDTO ,BindingResult validations) throws Exception{
		if(validations.hasErrors()){
			return new ResponseEntity<>("error en llenar los campos",HttpStatus.EXPECTATION_FAILED);
		}
		
		MessageResultDTO myuser = userservice.save(createUserDTO);
		switch (myuser.getMessage()) {
		case "Creado": {
			return new ResponseEntity<>("Usuario creado",HttpStatus.OK);
		}
		case "nombre de usuario no disponible":{
			return new ResponseEntity<>("nombre de usuario no disponible",HttpStatus.NOT_ACCEPTABLE);
			
			} 	
		default:
			return new ResponseEntity<>("Los campos no son validos",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value="/auth/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> SingInUser(@RequestBody @Valid UserSignInDTO info, BindingResult validations) throws Exception{
		if(validations.hasErrors()){
			return new ResponseEntity<>(validations.hasErrors(),HttpStatus.EXPECTATION_FAILED);
		}
		User user = userservice.logIn(info);
		if (user == null) {
			return new ResponseEntity<>("usuario no encontrado",HttpStatus.BAD_REQUEST);
		}
		try {
			Token token = userservice.registerToken(user);
			return new ResponseEntity<>(new TokenDTO(token), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> createEmployee(@PathVariable UUID id) throws Exception{
		MessageResultDTO result = userservice.deleteById(id);
		if(result.getMessage().equals("eliminado")) {
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/auth/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<?> ToggleUserAuth(@PathVariable UUID id) throws Exception{
		System.out.println(id);
		MessageResultDTO result = userservice.toggleAuthById(id);
		
		switch (result.getMessage()) {
		case "auth cambiado a true":
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		case "auth cambiado a false":
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		default:
			return new ResponseEntity<>(result.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/active/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<?> ToggleUserActive(@PathVariable UUID id) throws Exception{
		System.out.println(id);
		MessageResultDTO result = userservice.toggleActiveById(id);
		switch (result.getMessage()) {
		case "active cambiado a true":
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		case "active cambiado a false":
			return new ResponseEntity<>(result.getMessage(),HttpStatus.OK);
		default:
			return new ResponseEntity<>(result.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	// Movement controllers
	
	@GetMapping("/movement/all")
	public ResponseEntity<?> findAllMovements(){
		List<ShowMovementsDTO> resultMov = movementservice.findAll();
		
		if (resultMov != null) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>("lista vacia",HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/movement/all/page")
	public ResponseEntity<?> findAllMovementsPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size){
		PageDTO<ShowUserDTO> user = userservice.findAll(page, size);
		if (user != null) {
			return new ResponseEntity<>(user,HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("usuarios no encontrados",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/movement/{id}")
	public ResponseEntity<?> findAllMovements(@PathVariable UUID id){
		List<ShowMovementsDTO> resultMov = movementservice.findAllWereUserId(id);
		
		if (resultMov != null) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>("no campos relacionados a ese usuario",HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value= "/movement/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> createMovement(@RequestBody @Valid SaveMovementsDTO info, BindingResult result,@PathVariable UUID id) throws Exception{
		MessageResultDTO resultMov = movementservice.save(info,id);
		
		if (resultMov.getMessage().equals("Movimiento registrado")) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>(resultMov,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value= "/movement/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMovement(@PathVariable UUID id) throws Exception{
		MessageResultDTO resultMov = movementservice.deleteById(id);
		
		if (resultMov.getMessage().equals("Eliminado exitosamente")) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>(resultMov,HttpStatus.BAD_REQUEST);
	}
	
	// Assignment_rols controllers
	
	@GetMapping("/assignment/all")
	public ResponseEntity<?> finAllAssignments(){
		List<UserAndRolDTO> list = assigService.findAll();
		
		if (list != null) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/assignment/{id}")
	public ResponseEntity<?> CreateAssignment(@PathVariable UUID id) throws Exception{
		UserAndRolDTO resultMov = assigService.findAllWhereUserId(id);
		
		if (resultMov != null) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>("error en id",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/assignment")
	public ResponseEntity<?> CreateAssignment(@RequestBody @Valid AssignmentDTO info, BindingResult result) throws Exception{
		MessageResultDTO resultMov = assigService.Create(info);
		
		if (resultMov.getMessage().equals("rol asignado a usuario")) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>(resultMov,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value= "/assignment/del", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteOneWhereIdAssignment(@RequestBody DeleteRolFromUserDTO info) throws Exception{
		MessageResultDTO resultMov = assigService.deleteOneWhereUserId(info);
		
		if (resultMov.getMessage().equals("eliminado exitosamente")) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>(resultMov,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value= "/assignment/del/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAllWhereUserAssignment(@PathVariable UUID id) throws Exception{
		MessageResultDTO resultMov = assigService.deleteWhereUserId(id);
		
		if (resultMov.getMessage().equals("eliminado exitosamente")) {
			return new ResponseEntity<>(resultMov,HttpStatus.OK);
		}
	return new ResponseEntity<>(resultMov,HttpStatus.BAD_REQUEST);
	}
	
}	
