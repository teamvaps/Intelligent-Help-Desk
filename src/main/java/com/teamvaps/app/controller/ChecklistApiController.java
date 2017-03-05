package com.teamvaps.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.teamvaps.app.model.Checklist;
import com.teamvaps.app.service.ChecklistService;
import com.teamvaps.app.model.Usedchecklist;
import com.teamvaps.app.service.UsedchecklistService;
import com.teamvaps.app.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class ChecklistApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(ChecklistApiController.class);
	
	@Autowired
	ChecklistService checklistService;
	
	@Autowired
	UsedchecklistService usedchecklistService;
	
	
	@RequestMapping(value ="/checklist/", method = RequestMethod.GET)
	public ResponseEntity<List<Checklist>> listAllChecklist() {
		List<Checklist> checklist = checklistService.findAllChecklist();
		if(checklist.isEmpty()){
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Checklist>>(checklist, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/checklist/{type}", method = RequestMethod.GET)
	public ResponseEntity<List<Checklist>> getChecklist(@PathVariable("type") String type) {
		List<Checklist> checklist = checklistService.findByType(type);
		if(checklist == null){
			logger.error("No checklist found!");
			return new ResponseEntity(new CustomErrorType("No checklist found"), HttpStatus.NOT_FOUND);
		}
		logger.info("checklist found!");

		return new ResponseEntity<List<Checklist>>(checklist, HttpStatus.OK);
	}
//	Create checklist!
	@RequestMapping(value = "/checklist/", method = RequestMethod.POST)
	public ResponseEntity<?> createChecklist(@RequestBody Checklist checklist, UriComponentsBuilder ucBuilder) {
		logger.info("Creating checklist : {}", checklist);

		checklistService.saveChecklist(checklist);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/checklist/{id}").buildAndExpand(checklist.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
//	Delete checklist!
    @RequestMapping(value = "/checklist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteChecklist(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting checklist with id {}", id);
 
        Checklist checklist = checklistService.findById(id);
        if (checklist == null) {
            logger.error("Unable to delete. Checklist with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Checklist with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        checklistService.deleteChecklistById(id);
        logger.info("deleted the Checklist item!");
        return new ResponseEntity<Checklist>(HttpStatus.NO_CONTENT);
    }
//	Create usedchecklist!
	@RequestMapping(value = "/usedchecklist/", method = RequestMethod.POST)
	public ResponseEntity<?> createUsedChecklist(@RequestBody Usedchecklist usedchecklist) {

		usedchecklistService.saveUsedchecklist(usedchecklist);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
//	View usedchecklist!
	@RequestMapping(value = "/usedchecklist/{ticketid}", method = RequestMethod.POST)
	public ResponseEntity<List<Usedchecklist>> getUsedChecklist(@PathVariable("ticketid") Long ticketid) {
		List<Usedchecklist> usedchecklist = usedchecklistService.findAllByTicketId(ticketid);
		if(usedchecklist == null){
			logger.error("No usedchecklist found!");
			return new ResponseEntity(new CustomErrorType("No usedchecklist found"), HttpStatus.NOT_FOUND);
		}
		logger.info("usedchecklist found!");

		return new ResponseEntity<List<Usedchecklist>>(usedchecklist, HttpStatus.OK);
	}

}
