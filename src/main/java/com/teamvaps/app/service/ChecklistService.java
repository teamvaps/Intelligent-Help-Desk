package com.teamvaps.app.service;

import java.util.List;

import com.teamvaps.app.model.Checklist;

public interface ChecklistService {
	Checklist findById(Long id);

	List<Checklist> findByType(String type);

	Checklist findByItem(String item);

	Checklist findByAuthorId(Long authorid);

	void saveChecklist(Checklist checklist);

	void updateChecklist(Checklist checklist);

	void deleteChecklistById(Long id);

	void deleteAllChecklist();

	List<Checklist> findAllChecklist();

	List<Checklist> listByType(String type);


}
