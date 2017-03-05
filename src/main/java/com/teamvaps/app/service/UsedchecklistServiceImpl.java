package com.teamvaps.app.service;

import com.teamvaps.app.model.Usedchecklist;
import com.teamvaps.app.repositories.UsedchecklistRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("usedchecklistService")
@Transactional
public class UsedchecklistServiceImpl implements UsedchecklistService {
	
	@Autowired
	private UsedchecklistRepository usedchecklistRepository;
	
	public Usedchecklist findById(Long id) {
		return usedchecklistRepository.findOne(id);
	}


	
	
	@Override
	public void saveUsedchecklist(Usedchecklist usedchecklist) {
		usedchecklistRepository.save(usedchecklist);
	}

	@Override
	public void updateUsedchecklist(Usedchecklist usedchecklist) {
		saveUsedchecklist(usedchecklist);
	}

//	@Override
//	public void deleteChecklistById(Long id) {
//		checklistRepository.delete(id);
//	}
//
//	
//	@Override
//	public void deleteAllChecklist() {
//		checklistRepository.deleteAll();
//	}
//
	@Override
	public List<Usedchecklist> findAllUsedchecklist() {
		return usedchecklistRepository.findAll();
	}
//	@Override
//	public List<Checklist> listByType(String type) {
//		return checklistRepository.findByType1(type);
//	}

//	@Override
//	public Checklist findByItem(String item) {
//		return null;
//	}
	@Override
	public List<Usedchecklist> findAllByTicketId(Long ticketid) {
		return usedchecklistRepository.findByTicketid(ticketid);
	}
}
