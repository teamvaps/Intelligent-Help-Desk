package com.teamvaps.app.service;

import com.teamvaps.app.model.Ticket;

import java.util.List;

public interface TicketService {
	 Ticket findById(Long id);

	Ticket findByAuthorId(Long authorid);

	Ticket findByType(String type);

	Ticket findByStatus(String status);

	Ticket findByAgentId(Long agentid);

	void saveTicket(Ticket ticket);

	void updateTicket(Ticket ticket);

	void deleteTicketById(Long id);

	void deleteAllTickets();

	List<Ticket> findAllTickets();

	List<Ticket> findTicketsByAuthor(Long authorid);

}
