package com.nagarro.exittest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exittest.model.User;
import com.nagarro.exittest.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		service.register(user);
		return user.getFirstname() + " "+"registered successfully";
	}
	@GetMapping("/login/{email}")
	public User login(@PathVariable String email) {
		User user = service.login(email);


		if(user!=null) {
			return user;
		}
		
		return new User(-1,null,null,null,null);
		}
	}

