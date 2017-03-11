package com.teamvaps.app.service;

import com.teamvaps.app.model.Checklist;
import com.teamvaps.app.repositories.ChecklistRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("checklistService")
@Transactional
public class ChecklistServiceImpl implements ChecklistService {
	
	@Autowired
	private ChecklistRepository checklistRepository;
	
	public Checklist findById(Long id) {
		return checklistRepository.findOne(id);
	}

	@Override
	public List<Checklist> findByType(String type) {
		return checklistRepository.findByType(type);
	}
	
	@Override
	public void saveChecklist(Checklist checklist) {
		checklistRepository.save(checklist);
	}

	@Override
	public void updateChecklist(Checklist checklist) {
		saveChecklist(checklist);
	}

	@Override
	public void deleteChecklistById(Long id) {
		checklistRepository.delete(id);
	}

	
	@Override
	public void deleteAllChecklist() {
		checklistRepository.deleteAll();
	}

	@Override
	public List<Checklist> findAllChecklist() {
		return checklistRepository.findAll();
	}

	@Override
	public Checklist findByItem(String item) {
		return null;
	}

	@Override
	public List<Checklist> listByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}


}
