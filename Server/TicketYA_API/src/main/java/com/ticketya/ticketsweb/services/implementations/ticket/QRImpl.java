package com.ticketya.ticketsweb.services.implementations.ticket;


import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketya.ticketsweb.models.dtos.MessageResultDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.CreateQRDTO;
import com.ticketya.ticketsweb.models.dtos.ticket.ShowQRDTO;
import com.ticketya.ticketsweb.models.dtos.user.ShowUserDTO;
import com.ticketya.ticketsweb.models.entities.ticket.Ticket;
import com.ticketya.ticketsweb.models.entities.ticket.fk.QR;
import com.ticketya.ticketsweb.models.entities.user.User;
import com.ticketya.ticketsweb.repositories.ticket.CategoryTicketRepository;
import com.ticketya.ticketsweb.repositories.ticket.QRepository;
import com.ticketya.ticketsweb.repositories.ticket.TicketReposotiry;
import com.ticketya.ticketsweb.repositories.user.UserRespository;
import com.ticketya.ticketsweb.services.ticket.QRService;

import jakarta.transaction.Transactional;

@Service
public class QRImpl implements QRService {

	@Autowired
	private QRepository QRepository;
	
	@Autowired
	private TicketReposotiry ticketrepo;
	
	@Autowired
	private UserRespository userrepo;
	
	// All the functions get data from repositorys thats are already import and find 
	// one object by respective type and call again to the repositorys to delete,create,get...
	// The entire CRUD and more
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO create(CreateQRDTO inf) throws Exception {
		//looking to the values of the entitie and add with validations
		User findUser = userrepo.findById(inf.getUser()).orElse(null);
		
		if (findUser == null) {
			return new MessageResultDTO("usuario no encontrado");
		}
		
		QR newqr = new QR(inf.getTime(),
				inf.getCode(),
				findUser);
		
		QR verify = QRepository.findAll().stream().filter(e -> 
		e.getCode().equals(inf.getCode())).findAny().orElse(null);
		
		if (verify == null) {
			QRepository.save(newqr);
			return new MessageResultDTO("guardado exitosamente");
		}
		
		return new MessageResultDTO("error en campos");

	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public MessageResultDTO delete(UUID id) throws Exception {
		Ticket verify = ticketrepo.findAll().stream().filter(e -> 
		e.getQr().getId_qr()
		.equals(id))
		.findAny()
		.orElse(null);

if (verify == null) {
	QRepository.deleteById(id);
	return new MessageResultDTO("borrado exitosamente");
	
}
return new MessageResultDTO("La categoria esta asociada a algun ticket y no se puede borrar");
		
	}

	@Override
	public Timestamp findTimeByid(UUID id) {
		return QRepository.findById(id).map(e -> e.getTime()).orElse(null);
	}

	@Override
	public ShowQRDTO findOneByTicket(UUID id) {
		ShowQRDTO QR = QRepository.findById(id).map(e -> new ShowQRDTO(
				e.getId_qr(),
				e.getTime(),
				e.getCode(),
				new ShowUserDTO(e.getUserqr().getId_user()
				, e.getUserqr().getUsername()
				, e.getUserqr().getMail()
				, e.getUserqr().getAuthentication()))).orElse(null);
		
		return QR;
	}

	@Override
	public List<ShowQRDTO> findAllByUser(UUID id) {
		List<ShowQRDTO> qrsUser = QRepository.findAll().stream().filter(e -> e.getUserqr().getId_user().equals(id))
				.map(e -> new ShowQRDTO(
						e.getId_qr(),
						e.getTime(),
						e.getCode(),
						new ShowUserDTO(e.getUserqr().getId_user()
						, e.getUserqr().getUsername()
						, e.getUserqr().getMail()
						, e.getUserqr().getAuthentication()))).toList();
		return qrsUser;
	}

	@Override
	public List<ShowQRDTO> findAll() {
		return QRepository.findAll().stream().map(e -> new ShowQRDTO(
				e.getId_qr(),
				e.getTime(),
				e.getCode(),
				new ShowUserDTO(e.getUserqr().getId_user()
				, e.getUserqr().getUsername()
				, e.getUserqr().getMail()
				, e.getUserqr().getAuthentication()))).toList();
	}

}
