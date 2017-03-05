package com.teamvaps.app.repositories;


import com.teamvaps.app.model.Ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<Ticket, Long>{

	Ticket findByName(String name);
	List<Ticket> findByAuthorid(Long authorid);
}
