package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SuccessModel;
import com.example.demo.service.SuccessService;



@RestController 
@RequestMapping("/backendserver1/success")
public class SuccessController {
	
	
	
	@Autowired
	private SuccessService successServices;
	
	
	@GetMapping("/{accountNumber}")
	public List<SuccessModel> getTransactions(@PathVariable String accountNumber){
		
		return this.successServices.getTransactions(accountNumber);
		
	}
	

}
