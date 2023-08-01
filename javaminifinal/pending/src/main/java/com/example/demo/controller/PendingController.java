package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PendingModel;
import com.example.demo.service.PendingService;

@RestController
@RequestMapping("/backendserver3/pending")
public class PendingController {
	
	
	@Autowired
	private PendingService pendingServices;
	
	@GetMapping("/{accountnumber}")
	public List<PendingModel> getTransactions(@PathVariable("accountnumber") String accountNum){
		
		List<PendingModel> transL;
		
		try {
			transL= this.pendingServices.getTransactions(accountNum);
		}catch(Exception e) {
			
			transL = new ArrayList<>();
			
		}
		return transL;
	}

	
		@GetMapping
		public List<PendingModel> get(){
			
			return this.pendingServices.getAll();
		}
	
}
