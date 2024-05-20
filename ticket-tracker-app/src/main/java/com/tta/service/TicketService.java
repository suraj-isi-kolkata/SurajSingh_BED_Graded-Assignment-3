package com.tta.service;

import java.util.List;

import com.tta.entity.Ticket;

public interface TicketService {
	
	List<Ticket> allTickets();
	
	Ticket get(Long id);
	
	Ticket save(Ticket ticket);
	
	Ticket update(Ticket ticket);

	void deleteTicketByid(Long id);
	
	List<Ticket> findByKeyword(String keyword);

}
