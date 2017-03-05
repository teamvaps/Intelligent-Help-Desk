//package com.teamvaps.app.service;
//
//import com.teamvaps.app.model.Org;
//import com.teamvaps.app.repositories.OrgRepository;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//@Service("orgService")
//@Transactional
//public class OrgServiceImpl implements OrgService {
//	
//	@Autowired
//	private OrgRepository orgRepository;
//	
//	public Org findById(Long id) {
//		return orgRepository.findOne(id);
//	}
//
//	@Override
//	public Org findByName(String name) {
//		return orgRepository.findByName(name);
//	}
//	
//	
//	@Override
//	public Org findByLocation(String location){
//		return orgRepository.findByName(location);
//	}
//	@Override
//	public Org findByAuthorId(Long authorid){
//		return orgRepository.findOne(authorid);
//	}
//	@Override
//	public void saveOrg(Org Org) {
//		orgRepository.save(Org);
//	}
//
//	@Override
//	public void updateOrg(Org Org) {
//		saveOrg(Org);
//	}
//
//	@Override
//	public void deleteOrgById(Long id) {
//		orgRepository.delete(id);
//	}
//
//	
//	@Override
//	public void deleteAllOrg() {
//		orgRepository.deleteAll();
//	}
//
//	@Override
//	public List<Org> findAllOrg() {
//		return orgRepository.findAll();
//	}
//
//}
