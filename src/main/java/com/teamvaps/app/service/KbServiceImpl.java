//package com.teamvaps.app.service;
//
//import com.teamvaps.app.model.Kb;
//import com.teamvaps.app.repositories.KbRepository;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//@Service("kbService")
//@Transactional
//public class KbServiceImpl implements KbService {
//	
//	@Autowired
//	private KbRepository KbRepository;
//	
//	public Kb findById(Long id) {
//		return KbRepository.findOne(id);
//	}
//
//	
//	@Override
//	public Kb findByAuthorId(Long authorid){
//		return KbRepository.findOne(authorid);
//	}
//	@Override
//	public void saveKb(Kb Kb) {
//		KbRepository.save(Kb);
//	}
//
//	@Override
//	public void updateKb(Kb Kb) {
//		saveKb(Kb);
//	}
//
//	@Override
//	public void deleteKbById(Long id) {
//		KbRepository.delete(id);
//	}
//
//	
//	@Override
//	public void deleteAllKb() {
//		KbRepository.deleteAll();
//	}
//
//	@Override
//	public List<Kb> findAllKb() {
//		return KbRepository.findAll();
//	}
//
//}
