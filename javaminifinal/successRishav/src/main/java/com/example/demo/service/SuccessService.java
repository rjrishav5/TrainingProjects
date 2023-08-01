package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.dao.SuccessDao;
import com.example.demo.model.SuccessModel;



@Controller
public class SuccessService {
	
	
	
	@Autowired
	private SuccessDao successRepo;
	
	public  List<SuccessModel> getTransactions(String accNum){
		
		List transList;
		
		transList = this.successRepo.findByAccountNumberAndStatus(accNum, "success");
		
		return transList;
		
		
	}
	
	

}

