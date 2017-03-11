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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.teamvaps.app.model.Ticket;
import com.teamvaps.app.service.TicketService;
import com.teamvaps.app.model.User;
import com.teamvaps.app.service.UserService;
import com.teamvaps.app.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class TicketApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(TicketApiController.class);
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value ="/tickets/", method = RequestMethod.GET)
	public ResponseEntity<List<Ticket>> listAllTickets() {
		List<Ticket> tickets = ticketService.findAllTickets();
		if(tickets==null){
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/tickets/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Ticket>> listTicketsByName(@PathVariable("name") String name) {
		User user = userService.findByName(name);
		if(user==null){
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		Long authid=user.getId();
		logger.info("auth id is {}", authid);
		List<Ticket> tickets = ticketService.findAllTicketsByAuthor(authid);
		if(tickets.isEmpty()){
			logger.info("tickets not found");

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		logger.info("tickets found!");
		return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
	}
//	Create ticket!
	@RequestMapping(value = "/ticket/", method = RequestMethod.POST)
	public ResponseEntity<?> createTicket(@RequestBody Ticket ticket, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", ticket);

		ticketService.saveTicket(ticket);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/ticket/{id}").buildAndExpand(ticket.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
//	Delete ticket!
    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTicket(@PathVariable("id") long id) {
        logger.info("Fetching Ticket with id {}", id);
 
        Ticket ticket = ticketService.findById(id);
        if (ticket == null) {
            logger.error("Unable to delete. Ticket with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Ticket with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        logger.info("Fetched the ticket!");
        return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }

	
    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTicket(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Ticket with id {}", id);
 
        Ticket ticket = ticketService.findById(id);
        if (ticket == null) {
            logger.error("Unable to delete. Ticket with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Ticket with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        ticketService.deleteTicketById(id);
        logger.info("deleted the ticket!");
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
