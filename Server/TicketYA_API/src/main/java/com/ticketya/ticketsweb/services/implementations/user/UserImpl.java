package com.ticketya.ticketsweb.services.implementations.user;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowEventDTO;
import com.ticketya.ticketsweb.models.dtos.user.CreateUserDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowUserDTO;
import com.ticketya.ticketsweb.models.dtos.user.UserInfSingInDTO;
import com.ticketya.ticketsweb.models.dtos.user.UserSignInDTO;
import com.ticketya.ticketsweb.models.entities.user.Token;
import com.ticketya.ticketsweb.models.entities.user.User;
import com.ticketya.ticketsweb.repositories.user.TokenRepository;
import com.ticketya.ticketsweb.repositories.user.UserRespository;
import com.ticketya.ticketsweb.services.user.UserService;
import com.ticketya.ticketsweb.utils.GetUserUtil;
import com.ticketya.ticketsweb.utils.JWTTools;
import com.ticketya.ticketsweb.utils.PageDTO;

import jakarta.transaction.Transactional;

@Service
public class UserImpl implements UserService{
	
	@Autowired
	private UserRespository userrepo;
	
	@Autowired
	private GetUserUtil getuser;
	
	@Autowired
	private JWTTools jwtTools;
	
	@Autowired
	private TokenRepository tokenRepository;


		// All the functions get data from repositorys thats are already import and find 
		// one object by respective type and call again to the repositorys to delete,create,get...
		// The entire CRUD and more
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO save(CreateUserDTO info) throws Exception {
		User newuser = new User(
				info.getActive(),
				info.getUsername(),
				info.getPassword(),
				info.getMail(),
				info.getActive());
		
		//get all users
		List<User> users = userrepo.findAll();
		
		User compuser = users.stream().filter(e -> (e.getUsername().equals(newuser.getUsername())))
		.findAny()
		.orElse(null);
		if(compuser != null) {
			if(compuser.getUsername().equals(newuser.getUsername()))
				return new MessageResultDTO("nombre de usuario no disponible");
			
		}
		userrepo.save(newuser);
		return new MessageResultDTO("Creado");
		// TODO validations
		
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO deleteById(UUID id) throws Exception {
		User verify = userrepo.findById(id).orElse(null);
		if (verify == null) {
			return new MessageResultDTO("no se encontro a ningun usuario para eliminar");
		}
		userrepo.deleteById(id);
		return new MessageResultDTO("eliminado");
		// TODO validations
		
	}

	@Override
	public List<ShowUserDTO> findAll() {
		
		List<ShowUserDTO> allUsers = userrepo.findAll().stream().map(e -> new ShowUserDTO(e.getId_user(),
				e.getUsername(),
				e.getMail(),
				e.getAuthentication())).toList();
		
		return allUsers;
	}

	@Override
	public ShowUserDTO findOneById(UUID id) {
		User user = getuser.findUserById(id);
		
		if (user == null) {
			return null;
		}
		
		ShowUserDTO newUser = new ShowUserDTO(user.getId_user(),
				user.getUsername(),
				user.getMail(),
				user.getAuthentication());
		return newUser;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO toggleAuthById(UUID id) throws Exception {
		//getting user optional and converting to object user
		User user = getuser.findUserById(id);
		if (user == null) {
			return new MessageResultDTO("no se encontro usuario");
		}
		if(user.getAuthentication() == true) {
			user.setAuthentication(false);
			userrepo.save(user);
			return new MessageResultDTO("auth cambiado a false");
		}else {
			user.setAuthentication(true);
			userrepo.save(user);
			return new MessageResultDTO("auth cambiado a true");
		}
		
		// TODO validations corregir
		
	}
	
	@Override
	public MessageResultDTO toggleActiveById(UUID id) throws Exception {
		//getting user optional and converting to object user
				User user = getuser.findUserById(id);
				if (user == null) {
					return new MessageResultDTO("no se encontro usuario");
				}
				if(user.getActive() == true) {
					user.setActive(false);
					userrepo.save(user);
					return new MessageResultDTO("active cambiado a false");
				}else {
					user.setActive(true);
					userrepo.save(user);
					return new MessageResultDTO("active cambiado a true");
				}
		// TODO validations
	}	

	@Override
	public User logIn(UserSignInDTO userSignInDTO) {
		List<User> users = userrepo.findAll();
		
		User myuser = users.stream().filter(e -> ((e.getUsername().equals(userSignInDTO.getIdentifier()) ||
				e.getMail().equals(userSignInDTO.getIdentifier())) &&
				e.getPassword().equals(userSignInDTO.getPassword())))
		.findAny()
		.orElse(null);
		
		if(myuser == null){
			return null;
		}else if(myuser.getAuthentication() == false){
			return null;
		}

		/*UserInfSingInDTO userres = new UserInfSingInDTO(myuser.getUsername(),myuser.getMail(),myuser.getActive());
		*/
		return myuser;
	}

	@Override
	public User findByusername(String username) {
		User user = userrepo.findByUsername(username);

		if(user == null)
			throw new RuntimeException("El objeto opcional está vacío");
		else{			
			return user;
		}
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public Token registerToken(User user) throws Exception {
		cleanTokens(user);
		String tokenString = jwtTools.generateToken(user);
		Token token = new Token(tokenString, user);
		
		tokenRepository.save(token);
		return token;
	}

	@Override
	public Boolean isTokenValid(User user, String token) {
		try {
			cleanTokens(user);
			List<Token> tokens = tokenRepository.findByUserAndActive(user, true);
			
			tokens.stream()
				.filter(tk -> tk.getContent().equals(token))
				.findAny()
				.orElseThrow(() -> new Exception());
			
			return true;
		} catch (Exception e) {
			return false;
		}		
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void cleanTokens(User user) throws Exception {
		List<Token> tokens = tokenRepository.findByUserAndActive(user, true);
		
		tokens.forEach(token -> {
			if(!jwtTools.verifyToken(token.getContent())) {
				token.setActive(false);
				tokenRepository.save(token);
			}
		});
		
	}

	@Override
	public PageDTO<ShowUserDTO> findAll(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<ShowUserDTO> pageUser = userrepo.findAll(pageable)
				.map(e -> new ShowUserDTO(
						e.getId_user(),
						e.getUsername(),
						e.getMail(),
						e.getAuthentication()));
		
		
		PageDTO<ShowUserDTO> response = new PageDTO<>(
				pageUser.getContent(),
				pageUser.getNumber(),
				pageUser.getSize(),
				pageUser.getTotalElements(),
				pageUser.getTotalPages()
				);
		return response;
	}

	@Override
	public ShowUserDTO findOneByToken(String token) {
		token = token.substring(7);
		
		String username = jwtTools.getUsernameFrom(token);
		
		User user = userrepo.findByUsernameContains(username);
		if (user == null) {
			return null;
		}
		
		ShowUserDTO userdto = new ShowUserDTO(user.getId_user(), user.getUsername(),user.getMail(), user.getAuthentication());
		return userdto;
	}

	




}
