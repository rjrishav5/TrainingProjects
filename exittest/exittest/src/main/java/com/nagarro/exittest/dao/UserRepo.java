package com.nagarro.exittest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.exittest.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	
	
	User findByemail(String email);
	

}
