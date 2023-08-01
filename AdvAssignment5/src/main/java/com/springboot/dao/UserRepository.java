package com.springboot.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import com.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("FROM User t where t.username = ?1 AND t.password = ?2")
	public Optional<User> findUser(String username, String password);
}
