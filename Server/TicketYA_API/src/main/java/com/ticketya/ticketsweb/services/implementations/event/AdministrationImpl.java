package com.ticketya.ticketsweb.services.implementations.event;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.AdministrationDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowAdministrationDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowEventDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowUserDTO;
import com.ticketya.ticketsweb.models.entities.event.CategoryEvent;
import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.models.entities.event.fks.Administration;
import com.ticketya.ticketsweb.models.entities.user.User;
import com.ticketya.ticketsweb.repositories.event.AdministrationRepository;
import com.ticketya.ticketsweb.repositories.event.EventRespository;
import com.ticketya.ticketsweb.repositories.user.UserRespository;
import com.ticketya.ticketsweb.services.events.AdministrationService;

@Service
public class AdministrationImpl implements AdministrationService {
	
	@Autowired
	private AdministrationRepository admirepo;
	
	@Autowired
	private UserRespository userrepo;
	
	@Autowired
	private EventRespository eventrepo;

	// All the functions get data from repositorys thats are already import and find 
	// one object by respective type and call again to the repositorys to delete,create,get...
	// The entire CRUD and more
	
	@Override
	public MessageResultDTO save(AdministrationDTO info) {
		//looking to the values of the entitie and add with validations
		User user = userrepo.findById(info.getUser()).orElse(null);
		
		Event event = eventrepo.findById(info.getEvent()).orElse(null);
		
		if (user == null || event == null) {
			return new MessageResultDTO("Usuario o evento no existe");
		}
		
		Administration newAdministration = new Administration(event,
				user,
				info.getDate(),
				info.getGroup(),
				info.getAttendance());
		
		admirepo.save(newAdministration);
		
		return new MessageResultDTO("creado exitosamente");
		
	}


	@Override
	public List<ShowAdministrationDTO> findAttendanceWhereEvent(UUID id) {
		
		List<ShowAdministrationDTO> ListRegister = admirepo.findAll().stream()
				.map(e -> new ShowAdministrationDTO(e.getId_administration(),
						new ShowEventDTO(e.getEventadmi().getId_event(),
								e.getEventadmi().getTittle(),
								e.getEventadmi().getDate(),
								e.getEventadmi().getHour(),
								e.getEventadmi().getImage(),
								e.getEventadmi().getDuration()),
						new ShowUserDTO(e.getUseradmi().getId_user(),
								e.getUseradmi().getUsername(),
								e.getUseradmi().getMail(),
								e.getUseradmi().getAuthentication()),
						e.getDate(),
						e.getGroup(),
						e.getAttendance())).filter(e -> e.getShowEventDTO().getId().equals(id)).toList();
	
		
		return ListRegister;
	}

	@Override
	public List<ShowAdministrationDTO> findAttendanceWhereGeneral(String group) {
		List<ShowAdministrationDTO> ListRegister = admirepo.findAll().stream()
				.map(e -> new ShowAdministrationDTO(e.getId_administration(),
						new ShowEventDTO(e.getEventadmi().getId_event(),
								e.getEventadmi().getTittle(),
								e.getEventadmi().getDate(),
								e.getEventadmi().getHour(),
								e.getEventadmi().getImage(),
								e.getEventadmi().getDuration()),
						new ShowUserDTO(e.getUseradmi().getId_user(),
								e.getUseradmi().getUsername(),
								e.getUseradmi().getMail(),
								e.getUseradmi().getAuthentication()),
						e.getDate(),
						e.getGroup(),
						e.getAttendance())).filter(e -> e.getGroup().equals(group)).toList();
		
		
		return ListRegister;
	}

	@Override
	public List<ShowAdministrationDTO> findAll() {
		List<ShowAdministrationDTO> ListRegister = admirepo.findAll().stream()
				.map(e -> new ShowAdministrationDTO(e.getId_administration(),
						new ShowEventDTO(e.getEventadmi().getId_event(),
								e.getEventadmi().getTittle(),
								e.getEventadmi().getDate(),
								e.getEventadmi().getHour(),
								e.getEventadmi().getImage(),
								e.getEventadmi().getDuration()),
						new ShowUserDTO(e.getUseradmi().getId_user(),
								e.getUseradmi().getUsername(),
								e.getUseradmi().getMail(),
								e.getUseradmi().getAuthentication()),
						e.getDate(),
						e.getGroup(),
						e.getAttendance())).toList();
	
		return ListRegister;
	}

}
