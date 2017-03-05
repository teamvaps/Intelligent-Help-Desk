package com.teamvaps.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamvaps.app.model.Usedchecklist;

public interface UsedchecklistRepository extends JpaRepository<Usedchecklist, Long> {
	List<Usedchecklist> findByTicketid(Long ticketid);
}
