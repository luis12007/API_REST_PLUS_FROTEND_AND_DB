package com.ticketya.ticketsweb.services.implementations.event;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.event.CreateEventDTO;
import com.ticketya.ticketsweb.models.dtos.event.ShowEventDTO;
import com.ticketya.ticketsweb.models.entities.event.CategoryEvent;
import com.ticketya.ticketsweb.models.entities.event.Collaborator;
import com.ticketya.ticketsweb.models.entities.event.Event;
import com.ticketya.ticketsweb.models.entities.user.User;
import com.ticketya.ticketsweb.repositories.event.CategoryRepository;
import com.ticketya.ticketsweb.repositories.event.CollaboratorRepository;
import com.ticketya.ticketsweb.repositories.event.EventRespository;
import com.ticketya.ticketsweb.repositories.event.SponsorRepository;
import com.ticketya.ticketsweb.services.events.EventService;
import com.ticketya.ticketsweb.utils.PageDTO;

import jakarta.transaction.Transactional;

@Service
public class EventImpl implements EventService {

	@Autowired
	private EventRespository eventrepo;
	
	@Autowired
	private CategoryRepository categorepo;
	
	@Autowired
	private CollaboratorRepository collaborepo;

	// All the functions get data from repositorys thats are already import and find 
	// one object by respective type and call again to the repositorys to delete,create,get...
	// The entire CRUD and more
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO save(CreateEventDTO info) throws Exception {
		//looking to the values of the entitie and add with validations
		Collaborator newCollab = collaborepo.findById(info.getCollaborator()).orElse(null);
		
		CategoryEvent newCatego = categorepo.findById(info.getCategory()).orElse(null);
		
		
		if (newCollab == null || newCatego == null ) {
			return new MessageResultDTO("categoria o colaborador no existen");
		}
		
		List<Event> eventsRegistred = eventrepo.findAll();
		
		Event verify = eventsRegistred.stream()
				.filter(e -> e.getTittle().equals(info.getTittle()))
				.findAny().orElse(null);
		if (verify != null) {
			return new MessageResultDTO("nombre de evento no disponible");
		}
		List<Event> eventsFilter = eventsRegistred.stream()
				.filter(evento -> {
                    Calendar calEvento = Calendar.getInstance();
                    calEvento.setTime(evento.getDate());
                    Calendar calFechaDeseada = Calendar.getInstance();
                    calFechaDeseada.setTime(info.getDate());
                    return isSameDay(calEvento, calFechaDeseada);
                })
                .collect(Collectors.toList());

		LocalTime NewEventBegin = info.getHour().toLocalTime();
		LocalTime NewEventsEnd = NewEventBegin.plusMinutes(info.getDuration());
		System.out.println(NewEventBegin);
		System.out.println(NewEventsEnd);
		boolean horarioDisponible = true;
		
		System.out.println(eventsFilter);
		
        for (Event event : eventsFilter) {
        	
        	LocalTime EventRegistredBegin = event.getHour().toLocalTime();
        	LocalTime EventRegistredEnd = EventRegistredBegin.plusMinutes(event.getDuration());
      
        	System.out.println(EventRegistredBegin);
        	System.out.println(EventRegistredEnd);
            if (NewEventBegin.compareTo(EventRegistredBegin) >= 0 &&
            	NewEventBegin.compareTo(EventRegistredEnd) < 0) {
                // La hora de inicio del nuevo evento está entre la hora de inicio y fin de un evento existente
                horarioDisponible = false;
                break;
            }

            if (NewEventsEnd.compareTo(EventRegistredBegin) > 0 &&
            	NewEventsEnd.compareTo(EventRegistredEnd) <= 0) {
                // La hora de fin del nuevo evento está entre la hora de inicio y fin de un evento existente
                horarioDisponible = false;
                break;
            }
        }

        System.out.println(horarioDisponible);
        if (!horarioDisponible) {
        	return new MessageResultDTO("Horario no disponible para ese dia");
        }
				
		Event newEvent = new Event(
				info.getTittle(),
				info.getDate(),
				info.getHour(),
				newCatego,
				newCollab,
				info.getImage(),
				info.getDuration(),
				info.getPanic(),
				info.getEstado()
				);

		eventrepo.save(newEvent);

		return new MessageResultDTO("guardado exitosamente");
	}
	
	private static boolean isSameDay(Calendar cal1, Calendar cal2) {
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

	@Override
	public List<Event> findAll() {
		// TODO validations
		return eventrepo.findAll();
	}

	@Override
	public Event findOneById(UUID id) {
		// TODO validations
		return eventrepo.findById(id).orElse(null);
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO toogleState(UUID id) throws Exception {
		Event event = eventrepo.findById(id).orElse(null);
		 if (event == null) {
			 return new MessageResultDTO("evento no encontrado");
		}
		if(event.getEstado() == true) {
			event.setEstado(false);
			eventrepo.save(event);
			return new MessageResultDTO("estado cambiado a false");
		}else {
			event.setEstado(true);
			eventrepo.save(event);
			return new MessageResultDTO("estado cambiado a true");
		}
	}

	@Override
	public List<Event> FindByCategory(UUID id) {
		List<Event> eventByCatego = eventrepo.findAll()
				.stream()
				.filter(e -> e.getCategory().getId_category().equals(id))
				.toList();
		return eventByCatego;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO togglePanic(UUID id) throws Exception {
		Event event = eventrepo.findById(id).orElse(null);
		 if (event == null) {
			 return new MessageResultDTO("evento no encontrado");
		}
		if(event.getPanic() == true) {
			event.setPanic(false);
			event.setEstado(true);
			eventrepo.save(event);
			return new MessageResultDTO("evento reactivado");
		}else {
			event.setPanic(true);
			event.setEstado(false);
			eventrepo.save(event);
			return new MessageResultDTO("evento desactivado (emergencia)");
		}
	}

	@Override
	public PageDTO<ShowEventDTO> findEventsByCategory(String category, int page, int size) {
		if (!category.equals("")) {
			Pageable pageable = PageRequest.of(page, size);
			Page<ShowEventDTO> pageEvents = eventrepo.findByCategoryName(category, pageable)
					.map(e -> new ShowEventDTO(
							e.getId_event(),
							e.getTittle(),
							e.getDate(),
							e.getHour(),
							e.getImage(),
							e.getDuration()));
			
			System.out.println(pageEvents);
			PageDTO<ShowEventDTO> response = new PageDTO<>(
					pageEvents.getContent(),
					pageEvents.getNumber(),
					pageEvents.getSize(),
					pageEvents.getTotalElements(),
					pageEvents.getTotalPages()
					);	
			
			return response;
		}else if (category.equals("")) {
			Pageable pageable = PageRequest.of(page, size);
			Page<ShowEventDTO> pageEvents = eventrepo.findAll(pageable)
					.map(e -> new ShowEventDTO(
							e.getId_event(),
							e.getTittle(),
							e.getDate(),
							e.getHour(),
							e.getImage(),
							e.getDuration()));
			
			System.out.println(pageEvents);
			PageDTO<ShowEventDTO> response = new PageDTO<>(
					pageEvents.getContent(),
					pageEvents.getNumber(),
					pageEvents.getSize(),
					pageEvents.getTotalElements(),
					pageEvents.getTotalPages()
					);	
			
			return response;
		}
		return null;
		
		
	}

	@Override
	public PageDTO<ShowEventDTO> findEventsByName(String title, int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<ShowEventDTO> pageEvents = eventrepo.findAllByTittleContains(title, pageable)
				.map(e -> new ShowEventDTO(
						e.getId_event(),
						e.getTittle(),
						e.getDate(),
						e.getHour(),
						e.getImage(),
						e.getDuration()));
		
		
		PageDTO<ShowEventDTO> response = new PageDTO<>(
				pageEvents.getContent(),
				pageEvents.getNumber(),
				pageEvents.getSize(),
				pageEvents.getTotalElements(),
				pageEvents.getTotalPages()
				);
		
		return response;
	}
	


}
