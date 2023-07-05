package com.ticketya.ticketsweb.services.implementations.ticket;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowEventDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.ChangeOwnerDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.CreateTicketDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.ShowQRDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.ShowTicketDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowUserDTO;
import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.models.entities.ticket.CategoryTicket;
import com.ticketya.ticketsweb.models.entities.ticket.Ticket;
import com.ticketya.ticketsweb.models.entities.ticket.fk.QR;
import com.ticketya.ticketsweb.models.entities.user.User;
import com.ticketya.ticketsweb.repositories.event.EventRespository;
import com.ticketya.ticketsweb.repositories.ticket.CategoryTicketRepository;
import com.ticketya.ticketsweb.repositories.ticket.QRepository;
import com.ticketya.ticketsweb.repositories.ticket.TicketReposotiry;
import com.ticketya.ticketsweb.repositories.user.UserRespository;
import com.ticketya.ticketsweb.services.ticket.TicketService;
import com.ticketya.ticketsweb.utils.JWTTools;
import com.ticketya.ticketsweb.utils.PageDTO;

import jakarta.transaction.Transactional;

@Service
public class TicketImpl implements TicketService {
	
	@Autowired
	private JWTTools jwtTools;

	@Autowired
	private TicketReposotiry ticketrepo;
	
	@Autowired
	private EventRespository eventrepo;
	
	@Autowired
	private QRepository qrepo;
	
	@Autowired
	private CategoryTicketRepository categoryrepo;
	
	@Autowired
	private UserRespository userepo;
	
	// All the functions get data from repositorys thats are already import and find 
	// one object by respective type and call again to the repositorys to delete,create,get...
	// The entire CRUD and more
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO save(CreateTicketDTO info) throws Exception {
		//looking to the values of the entitie and add with validations
		CategoryTicket category = categoryrepo.findAll().stream().filter(
				e -> e.getId_category().equals(info.getCategory())).findAny().orElse(null);
		
		QR qr = qrepo.findAll().stream().filter(
				e -> e.getId_qr().equals(info.getQr())).findAny().orElse(null);
		
		User user = userepo.findAll().stream().filter(
				e -> e.getId_user().equals(info.getUser())).findAny().orElse(null);
		
		Event event = eventrepo.findAll().stream().filter(
				e -> e.getId_event().equals(info.getEvent())).findAny().orElse(null);
		
		if (category == null || qr == null || user == null || event == null) {
			return new MessageResultDTO("campos invalidos");
		}
	
		
		Ticket newticket = new Ticket(
				info.getTier(),
				user,
				info.getOwner(),
				info.getActive(),
				event,
				qr,
				category);
		
		ticketrepo.save(newticket);
		
		return new MessageResultDTO("ticket creado");
		
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO toggleActive(UUID id) throws Exception {
		Ticket ticket = ticketrepo.findById(id).orElse(null);
		
		if (ticket == null) {
			return new MessageResultDTO("error en id");
		}
		 
		if(ticket.getActive() == true) {
			ticket.setActive(false);
			ticketrepo.save(ticket);
			return new MessageResultDTO("ticket cambiado a desactivado");
		}else {
			ticket.setActive(true);
			ticketrepo.save(ticket);
			return new MessageResultDTO("ticket cambiado a activo");
		}
		
	}

	@Override
	public List<ShowTicketDTO> findAll() {
		return ticketrepo.findAll()
				.stream()
				.map(e -> new ShowTicketDTO(
						e.getId_ticket(),
						e.getTier(),
						e.getOwner(),
						e.getActive(),
						new ShowUserDTO(
								e.getUser().getId_user(),
								e.getUser().getUsername(),
								e.getUser().getMail(),
								e.getUser().getAuthentication()),
						new ShowEventDTO(e.getEventticket().getId_event(),
								e.getEventticket().getTittle(),
								e.getEventticket().getDate(),
								e.getEventticket().getHour(),
								e.getEventticket().getImage(),
								e.getEventticket().getDuration()),
						new ShowQRDTO(
								e.getQr().getId_qr(),
								e.getQr().getTime(),
								e.getQr().getCode(),
								new ShowUserDTO(
										e.getUser().getId_user(),
										e.getUser().getUsername(),
										e.getUser().getMail(),
										e.getUser().getAuthentication())))).toList();
	}

	@Override
	public ShowTicketDTO findOneByid(UUID id) {
		ShowTicketDTO ticket = ticketrepo.findAll().stream().filter(
				e -> e.getId_ticket().equals(id)).map(e -> new ShowTicketDTO(
						e.getId_ticket(),
						e.getTier(),
						e.getOwner(),
						e.getActive(),
						new ShowUserDTO(
								e.getUser().getId_user(),
								e.getUser().getUsername(),
								e.getUser().getMail(),
								e.getUser().getAuthentication()),
						new ShowEventDTO(e.getEventticket().getId_event(),
								e.getEventticket().getTittle(),
								e.getEventticket().getDate(),
								e.getEventticket().getHour(),
								e.getEventticket().getImage(),
								e.getEventticket().getDuration()),
						new ShowQRDTO(
								e.getQr().getId_qr(),
								e.getQr().getTime(),
								e.getQr().getCode(),
								new ShowUserDTO(
										e.getUser().getId_user(),
										e.getUser().getUsername(),
										e.getUser().getMail(),
										e.getUser().getAuthentication())))).findAny().orElse(null);
		return ticket;
	}

	@Override
	public List<ShowTicketDTO> findAllWhereUserid(UUID id) {
		List<ShowTicketDTO> ticketlist = ticketrepo.findAll().stream().filter(
				e -> e.getOwner().equals(id)).map(e -> new ShowTicketDTO(
						e.getId_ticket(),
						e.getTier(),
						e.getOwner(),
						e.getActive(),
						new ShowUserDTO(
								e.getUser().getId_user(),
								e.getUser().getUsername(),
								e.getUser().getMail(),
								e.getUser().getAuthentication()),
						new ShowEventDTO(e.getEventticket().getId_event(),
								e.getEventticket().getTittle(),
								e.getEventticket().getDate(),
								e.getEventticket().getHour(),
								e.getEventticket().getImage(),
								e.getEventticket().getDuration()),
						new ShowQRDTO(
								e.getQr().getId_qr(),
								e.getQr().getTime(),
								e.getQr().getCode(),
								new ShowUserDTO(
										e.getUser().getId_user(),
										e.getUser().getUsername(),
										e.getUser().getMail(),
										e.getUser().getAuthentication())))).toList();
		return ticketlist;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO changeOwner(ChangeOwnerDTO changeOwnerDTO) throws Exception {
		Ticket ticket = ticketrepo.findAll().stream()
				.filter(e ->e.getQr().getCode()
				.equals(changeOwnerDTO.getHash()))
				.findAny().orElse(null);
		 
		System.out.println(changeOwnerDTO);
		System.out.println(ticket);
		if(ticket.getOwner().equals(changeOwnerDTO.getUserowner()) && ticket.getQr().getCode().equals(changeOwnerDTO.getHash())) {
			ticket.setOwner(changeOwnerDTO.getNewowner());
			User newuser = userepo.findById(changeOwnerDTO.getNewowner()).orElse(null);
			ticket.getQr().setUserqr(newuser);
			ticketrepo.save(ticket);
			return new MessageResultDTO("ticket ha cambiado de dueño");
		}
		return new MessageResultDTO("error los campos no coinciden");
		
	}

	@Override
	public PageDTO<ShowTicketDTO> findAllWhereUseridpage(String token, int page, int size) {
		token = token.substring(7);
		
		String username = jwtTools.getUsernameFrom(token);
		
		User user1 = userepo.findByUsername(username);
		
		if (user1 == null) {
			return null;
		}
		Pageable pageable = PageRequest.of(page, size);
		Page<ShowTicketDTO> PageTicket = ticketrepo.findAllByOwner(user1.getId_user(), pageable)
				.map(e -> new ShowTicketDTO(
						e.getId_ticket(),
						e.getTier(),
						e.getOwner(),
						e.getActive(),
						new ShowUserDTO(
								e.getUser().getId_user(),
								e.getUser().getUsername(),
								e.getUser().getMail(),
								e.getUser().getAuthentication()),
						new ShowEventDTO(e.getEventticket().getId_event(),
								e.getEventticket().getTittle(),
								e.getEventticket().getDate(),
								e.getEventticket().getHour(),
								e.getEventticket().getImage(),
								e.getEventticket().getDuration()),
						new ShowQRDTO(
								e.getQr().getId_qr(),
								e.getQr().getTime(),
								e.getQr().getCode(),
								new ShowUserDTO(
										e.getUser().getId_user(),
										e.getUser().getUsername(),
										e.getUser().getMail(),
										e.getUser().getAuthentication()))));
		
		PageDTO<ShowTicketDTO> response = new PageDTO<>(
				PageTicket.getContent(),
				PageTicket.getNumber(),
				PageTicket.getSize(),
				PageTicket.getTotalElements(),
				PageTicket.getTotalPages()
				);
		return response;
	}


}
