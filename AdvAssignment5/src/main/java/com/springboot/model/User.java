package com.springboot.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
//	@NotBlank(message="Cannot be empty!)")
//	@Size(min=5,max=50,message="username must be between 5-50")
	
	private String username;
public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String password) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
	}
	//	
//	@NotBlank(message="Cannot be empty!)")
//	@Size(min=5,max=50,message="password must be between 5-50")
	private String password;


	
	}

	
	


