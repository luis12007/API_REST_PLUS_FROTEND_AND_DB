package com.ticketya.ticketsweb.services.implementations.ticket;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.SaveCategoryTicketDTO;
import com.ticketya.ticketsweb.models.entities.ticket.CategoryTicket;
import com.ticketya.ticketsweb.models.entities.ticket.Ticket;
import com.ticketya.ticketsweb.repositories.ticket.CategoryTicketRepository;
import com.ticketya.ticketsweb.repositories.ticket.TicketReposotiry;
import com.ticketya.ticketsweb.services.ticket.CategoryService;

import jakarta.transaction.Transactional;

@Service
public class CategoryTicketImpl implements CategoryService{
	
	@Autowired
	private CategoryTicketRepository categorepo;
	
	@Autowired
	private TicketReposotiry ticketrepo;
	
	// All the functions get data from repositorys thats are already import and find 
	// one object by respective type and call again to the repositorys to delete,create,get...
	// The entire CRUD and more
	

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO create(SaveCategoryTicketDTO inf) throws Exception {
		//looking to the values of the entitie and add with validations
		CategoryTicket newCatego = new CategoryTicket(inf.getPrice(),inf.getCapacity());
		
		CategoryTicket verify = categorepo.findAll().stream().filter(e -> 
								e.getPrice().equals(inf.getPrice())
								&& e.getCapacity().equals(inf.getCapacity()))
								.findAny().orElse(null);
		
		if (verify == null) {
			categorepo.save(newCatego);
			return new MessageResultDTO("creado exitosamente");
		}
		
		return new MessageResultDTO("categoria ya exsite");
		
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO delete(UUID id) throws Exception {
		Ticket verify = ticketrepo.findAll().stream().filter(e -> 
				e.getCategory().getId_category()
				.equals(id))
				.findAny()
				.orElse(null);
		
		if (verify == null) {
			categorepo.deleteById(id);
			return new MessageResultDTO("borrado exitosamente");
			
		}
		return new MessageResultDTO("La categoria esta asociada a algun ticket y no se puede borrar");
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO updatePrice(SaveCategoryTicketDTO inf, UUID id) throws Exception {
		CategoryTicket updateCate = categorepo.findById(id).orElse(null);
		
		
		
		if (updateCate == null) {
			return new MessageResultDTO("error en id");
		}
		
		CategoryTicket verify = categorepo.findAll().stream()
				.filter(e -> e.getCapacity().equals(inf.getCapacity())
						&& e.getPrice().equals(inf.getPrice())).findAny().orElse(null);
		
		if (verify != null) {
			return new MessageResultDTO("esta categoria ya existe");
		}
		
		updateCate.setCapacity(inf.getCapacity());
		updateCate.setPrice(inf.getPrice());
		
		
		
		categorepo.save(updateCate);
		
		return new MessageResultDTO("categoria editada");
	}

	@Override
	public List<CategoryTicket> findAll() {
		return categorepo.findAll();
	}


}
