package com.teamvaps.app.repositories;

import com.teamvaps.app.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByName(String name);
	List<User> findByPhone(String phone);

}
