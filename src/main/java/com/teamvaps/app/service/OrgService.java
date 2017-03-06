package com.teamvaps.app.service;

import java.util.List;

import com.teamvaps.app.model.Org;

public interface OrgService {

	Org findByName(String name);

	Org findByLocation(String location);

	Org findByAuthorId(Long authorid);

	void saveOrg(Org Org);

	void updateOrg(Org Org);

	void deleteOrgById(Long id);

	void deleteAllOrg();

	List<Org> findAllOrg();

}
