package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PendingDao;
import com.example.demo.model.PendingModel;

@Service
public class PendingService {
	@Autowired
	private PendingDao pendingRepo;
	
	
	//To get the Pending transactions 
	public List<PendingModel> getTransactions(String accNum){
		
		
		List<PendingModel> transList = null;
		
		try {
			transList = this.pendingRepo.findByAccountNumberAndStatus(accNum, "pending");
		}catch(Exception e) {
			
			transList = new ArrayList<>();
		}
		return transList;
	}
	public List<PendingModel> getAll(){
		List<PendingModel> transList= this.pendingRepo.findAll();
		return transList;
	}
	

}
