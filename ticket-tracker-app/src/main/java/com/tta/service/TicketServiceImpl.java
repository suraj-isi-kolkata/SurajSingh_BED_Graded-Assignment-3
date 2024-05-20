package com.tta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tta.entity.Ticket;
import com.tta.repository.TicketRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
	
	private final TicketRepository repository;

	@Override
	public Ticket save(Ticket ticket) {
		return repository.save(ticket);
	}

	@Override
	public List<Ticket> allTickets() {
		return repository.findAll();
	}

	@Override
	public Ticket get(Long id) {
		return repository.findById(id).orElseThrow();
	}

	@Override
	public Ticket update(Ticket ticket) {
		Optional<Ticket> ticketFromDb = repository.findById(ticket.getId());
		
		if(ticketFromDb.isPresent()) {
			Ticket updateTicket = ticketFromDb.get();
			updateTicket.setTitle(ticket.getTitle());
			updateTicket.setDescription(ticket.getDescription());
			updateTicket.setContent(ticket.getContent());
			updateTicket.setCreatedAt(ticket.getCreatedAt());
			return repository.save(updateTicket);
		}
		return ticket;
		
	}

	@Override
	public void deleteTicketByid(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Ticket> findByKeyword(String keyword) {
		return repository.findByKeyword(keyword);
	}

}
