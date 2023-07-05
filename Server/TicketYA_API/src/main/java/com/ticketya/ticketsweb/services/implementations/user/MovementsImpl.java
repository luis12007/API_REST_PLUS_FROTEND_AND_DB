package com.ticketya.ticketsweb.services.implementations.user;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.user.SaveMovementsDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowMovementsDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowUserDTO;
import com.ticketya.ticketsweb.models.entities.user.Movements;
import com.ticketya.ticketsweb.models.entities.user.User;
import com.ticketya.ticketsweb.repositories.user.MovementsRepository;
import com.ticketya.ticketsweb.repositories.user.UserRespository;
import com.ticketya.ticketsweb.services.user.MovementsService;
import com.ticketya.ticketsweb.utils.PageDTO;

import jakarta.transaction.Transactional;

@Service
public class MovementsImpl implements MovementsService {
	
	@Autowired
	private MovementsRepository movrepo;
	
	@Autowired
	private	UserRespository userepo;

	// All the functions get data from repositorys thats are already import and find 
	// one object by respective type and call again to the repositorys to delete,create,get...
	// The entire CRUD and more
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO save(SaveMovementsDTO inf, UUID id) throws Exception {
		//looking to the values of the entitie and add with validations
		User User = userepo.findById(id).orElse(null);
		
		if (User == null) {
			return new MessageResultDTO("usuario no encontrado");
		}
		System.out.println(inf.getMovement());
		
		if (inf.getMovement().equals("adicion") || inf.getMovement().equals("elimino")
				|| inf.getMovement() == "edicion"
				|| inf.getMovement() == "baneo"
				|| inf.getMovement() == "escaneo") {
			Movements newmov = new Movements(inf.getMovement(),User, inf.getDescrip());
			movrepo.save(newmov);
			return new MessageResultDTO("Movimiento registrado");
		}
		
		return new MessageResultDTO("Tipo de movimiento no valido");
		
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO deleteById(UUID id) throws Exception {
		
		Movements mov = movrepo.findById(id).orElse(null);
		
		if (mov == null) {
			return new MessageResultDTO("el registro no existe");
		}
		movrepo.deleteById(id);
		
		return new MessageResultDTO("Eliminado exitosamente");
		
	}

	@Override
	public List<ShowMovementsDTO> findAll() {
		List<ShowMovementsDTO> movements = movrepo.findAll().stream()
				.map(e -> new ShowMovementsDTO(
						e.getId_movement(),
						e.getMovement(),
						e.getDescrip(),
						new ShowUserDTO(
						e.getUser_mov().getId_user(),
						e.getUser_mov().getUsername(),
						e.getUser_mov().getMail(),
						e.getUser_mov().getAuthentication()))).toList();
		
		return movements;
	}

	@Override
	public List<ShowMovementsDTO> findAllWereUserId(UUID id) {
		List<ShowMovementsDTO> fulllist = movrepo.findAll().stream()
				.filter(e -> e.getUser_mov().getId_user().equals(id)).map(e -> new ShowMovementsDTO(
						e.getId_movement(),
						e.getMovement(),
						e.getDescrip(),
						new ShowUserDTO(
						e.getUser_mov().getId_user(),
						e.getUser_mov().getUsername(),
						e.getUser_mov().getMail(),
						e.getUser_mov().getAuthentication()))).toList();

		return fulllist;
	}

	@Override
	public PageDTO<ShowMovementsDTO> findAll(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<ShowMovementsDTO> pageUser = movrepo.findAll(pageable)
				.map(e -> new ShowMovementsDTO(
						e.getId_movement(),
						e.getMovement(),
						e.getDescrip(),
						new ShowUserDTO(
						e.getUser_mov().getId_user(),
						e.getUser_mov().getUsername(),
						e.getUser_mov().getMail(),
						e.getUser_mov().getAuthentication())));
		
		
		PageDTO<ShowMovementsDTO> response = new PageDTO<>(
				pageUser.getContent(),
				pageUser.getNumber(),
				pageUser.getSize(),
				pageUser.getTotalElements(),
				pageUser.getTotalPages()
				);
		return response;
	}

}
