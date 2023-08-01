package com.nagarro.exittest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nagarro.exittest.dao.UserRepo;
import com.nagarro.exittest.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepo repository;
	
	public User register( User user) {
		return repository.save(user);
		
	}
	public User login(String email) {
		return repository.findByemail(email);
	}

}
