package com.teamvaps.app.service;

import com.teamvaps.app.model.User;

import java.util.List;

public interface UserService {
	
	 User findById(Long id);
	 
	 User findByName(String name);
	 
	 User findByEmail(String email);
	 
	 User findByRole(String role);
	 
	 User findByPhone(String phone);
	 
	 void saveUser(User user);
	 
	 void updateUser(User user);
	 
	 void deleteUserById(Long id);

	 boolean isUserExist(User user);
	 
	 boolean isAdmin(User user);
	 
	 boolean isAgent(User user);
	 
	 void deleteAllUsers();
	 
	 List<User> findAllUsers();

	 
}
