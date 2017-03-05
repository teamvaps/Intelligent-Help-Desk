package com.teamvaps.app.service;

import com.teamvaps.app.model.Ticket;
import com.teamvaps.app.repositories.TicketRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ticketService")
@Transactional
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	public Ticket findById(Long id) {
		return ticketRepository.findOne(id);
	}

	@Override
	public Ticket findByAuthorId(Long authorid) {
		return ticketRepository.findOne(authorid);
	}
	
	@Override
	public Ticket findByType(String type){
		return ticketRepository.findByName(type);
	}
	@Override
	public Ticket findByStatus(String status){
		return ticketRepository.findByName(status);
	}
	
	@Override
	public Ticket findByAgentId(Long agentid){
		return ticketRepository.findOne(agentid);
	}
	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		saveTicket(ticket);
	}

	@Override
	public void deleteTicketById(Long id) {
		ticketRepository.delete(id);
	}

	public boolean isTicketExist(Ticket ticket) {
		return findById(ticket.getId())!=null;
	}
	
	@Override
	public void deleteAllTickets() {
		ticketRepository.deleteAll();
	}
	
	@Override
	public List<Ticket> findAllTickets() {
		return ticketRepository.findAll();
	}
	@Override
	public List<Ticket> findTicketsByAuthor(Long authorid) {
		return ticketRepository.findByAuthorid(authorid );
	}
}
