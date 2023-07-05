package com.ticketya.ticketsweb.services.implementations.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.user.AssignmentDTO;
import com.ticketya.ticketsweb.models.dtos.user.DeleteRolFromUserDTO;
import com.ticketya.ticketsweb.models.dtos.user.UserAndRolDTO;
import com.ticketya.ticketsweb.models.entities.user.Rols;
import com.ticketya.ticketsweb.models.entities.user.User;
import com.ticketya.ticketsweb.models.entities.user.fks.Assignment;
import com.ticketya.ticketsweb.repositories.user.AssignmentRepository;
import com.ticketya.ticketsweb.repositories.user.MovementsRepository;
import com.ticketya.ticketsweb.repositories.user.RolsRepository;
import com.ticketya.ticketsweb.repositories.user.UserRespository;
import com.ticketya.ticketsweb.services.user.AssignmentService;

@Service
public class AssignmentImpl implements AssignmentService {
	
	@Autowired
	private AssignmentRepository assignrepo;
	
	@Autowired
	private	UserRespository userepo;
	
	@Autowired
	private RolsRepository rolsrepo;

	// All the functions get data from repositorys thats are already import and find 
	// one object by respective type and call again to the repositorys to delete,create,get...
	// The entire CRUD and more

	@Override
	public MessageResultDTO Create(AssignmentDTO info) throws Exception {
		//looking to the values of the entitie and add with validations
		User user = userepo.findById(info.getUser()).orElse(null);
		
		Rols rol = rolsrepo.findById(info.getRol()).orElse(null);
		
		if (user == null || rol == null) {
			return new MessageResultDTO("usuario o rol no existe");
		}
		
		List<Assignment> verify = assignrepo.findAll().stream()
				.filter(e -> e.getAssiguser()
				.getId_user().equals(info.getUser()) 
				&& e.getRol().getId_rol().equals(info.getRol())).toList();
		
		if (!verify.isEmpty()) {
			return new MessageResultDTO("el usuario ya tiene el rol");
		}
		
		
		
		Assignment newassign = new Assignment(rol,user);
		assignrepo.save(newassign);
		
		return new MessageResultDTO("rol asignado a usuario");
	}

	@Override
	public MessageResultDTO deleteWhereUserId(UUID id) throws Exception {
		
		List<Assignment> listAssign = assignrepo.findAll().stream().filter(e -> e.getAssiguser().getId_user().equals(id)).toList();
		List<UUID> listDelete = listAssign.stream().map(e -> e.getId_assignment()).toList();
		assignrepo.deleteAllById(listDelete);

		return new MessageResultDTO("eliminado exitosamente");
		
	}
	
	@Override
	public MessageResultDTO deleteOneWhereUserId(DeleteRolFromUserDTO info) throws Exception {
		Assignment listAssign = assignrepo.findAll().stream().filter(e -> e.getAssiguser()
				.getId_user().equals(info.getUser()) 
				&& e.getRol().getName().equals(info.getRol())).findFirst().orElse(null);
		if (listAssign == null) {
			return new MessageResultDTO("no encontrado");
		}
		assignrepo.deleteById(listAssign.getId_assignment());
		return new MessageResultDTO("eliminado exitosamente");
	}

	@Override
	public UserAndRolDTO findAllWhereUserId(UUID id) {
		List<Assignment> allAssign = assignrepo.findAll();
		List<User> allUsers = userepo.findAll();
		
		
		
		String user = allUsers.stream()
	            .filter(u -> u.getId_user().equals(id))
	            .map(e -> e.getUsername())
	            .findFirst()
	            .orElse(null);
		
		if (user == null) {
			return null;
		}
    	
    	List<String> rols = allAssign.stream()
    			.filter(e -> e.getAssiguser().getId_user().equals(id))
	            .map(e -> e.getRol().getName())
	            .collect(Collectors.toList());
    	System.out.println(rols);
    	return new UserAndRolDTO(user,rols);
	}

	@Override
	public List<UserAndRolDTO> findAll() {
		List<UserAndRolDTO> listReturn = new ArrayList<>();
		List<Assignment> allAssign = assignrepo.findAll();
		List<User> allUsers = userepo.findAll();
		
		Set<UUID> idsUnicos = new HashSet<>();

        for (Assignment objeto : allAssign) {
        	idsUnicos.add(objeto.getAssiguser().getId_user());
        }

        for (UUID id : idsUnicos) {
        	
        	String user = allUsers.stream()
		            .filter(u -> u.getId_user() == id)
		            .map(e -> e.getUsername())
		            .findFirst()
		            .orElse(null);
        	
        	List<String> rols = allAssign.stream()
        			.filter(e -> e.getAssiguser().getId_user() == id)
		            .map(e -> e.getRol().getName())
		            .collect(Collectors.toList());
        	
        	listReturn.add(new UserAndRolDTO(user,rols));
        	
        	
            System.out.println(id);
        }


		return listReturn;
	}


}
