package com.teamvaps.app.service;

import com.teamvaps.app.model.User;
import com.teamvaps.app.repositories.UserRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByName(email);
	}

	@Override
	public User findByRole(String role) {
		return userRepository.findByName(role);
	}

	@Override
	public User findByPhoneNumber(String phone) {
		return userRepository.findByName(phone);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		saveUser(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.delete(id);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	@Override
	public boolean isAdmin(User user) {
		return isUserExist(user)||findByName(user.getRole()).toString()=="Admin";
	}

	@Override
	public boolean isAgent(User user) {
		return isUserExist(user)||findByName(user.getRole()).toString()=="Agent";
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	@Override
	public List<User> findAllByPhone(String phone) {
		return userRepository.findByPhone(phone);
	}
	
	

}
