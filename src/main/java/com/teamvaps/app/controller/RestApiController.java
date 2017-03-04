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

import com.teamvaps.app.model.User;
import com.teamvaps.app.service.UserService;
import com.teamvaps.app.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value ="/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUser() {
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()){
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id) {
		logger.info("Fetching user with id {}", id);
		User user = userService.findById(id);
		if(user == null){
			logger.error("User with id {} not found", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/authenticate", params = { "name", "password" }, method = RequestMethod.POST)
	public ResponseEntity<?> checkUser(@RequestParam("name") String name, @RequestParam("password") String password) {
		User user = userService.findByName(name);
        if (user == null) {
            logger.error("Unable to login User with name {} not found.", name);
            return new ResponseEntity(new CustomErrorType("Unable to login. User with name " + name + " not found."),
                    HttpStatus.UNAUTHORIZED);
        }
		int c = user.getPassword().compareTo(password);
		if(c==1){
			logger.error("The password you entered is wrong");
			return new ResponseEntity(new CustomErrorType("User with name"+ name+"'s password is wrong"), HttpStatus.UNAUTHORIZED);
		}
		logger.info("just a debug "+c);
		logger.info("logging in user {}", name);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", user);

		if (userService.isUserExist(user)) {
			logger.error("Unable to create. A User with name {} already exist", user.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
			user.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	

	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user){
		logger.info("Updating user with id {}", id);
		
		User currentUser = userService.findById(id);
		
		if(currentUser == null){
			logger.error("Unable to update the user with id {} not found", id);
			return new ResponseEntity(new CustomErrorType("Unable to update. User with " + id + " not found."), HttpStatus.NOT_FOUND);
		}
		currentUser.setName(user.getName());
		currentUser.setEmail(user.getEmail());
		currentUser.setPhone(user.getPhone());
		currentUser.setPassword(user.getPassword());
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
		}
	
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting User with id {}", id);
 
        User user = userService.findById(id);
        if (user == null) {
            logger.error("Unable to delete. User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
