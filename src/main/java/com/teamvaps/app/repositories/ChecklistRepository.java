package com.teamvaps.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamvaps.app.model.Checklist;


public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
	
	
	List<Checklist> findByType(String type);
}
