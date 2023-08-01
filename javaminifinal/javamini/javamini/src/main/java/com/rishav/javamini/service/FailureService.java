package com.rishav.javamini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rishav.javamini.dao.FailureDao;
import com.rishav.javamini.model.AccountInfo;



@ Service
public class FailureService {
	@Autowired
	private FailureDao failureDao;

public List<AccountInfo> getTransactions(String accNum){
		List<AccountInfo> transList;
		transList = this.failureDao.findByAccountNumberAndStatus(accNum, "failure");
		
		return transList;
		
	}

	
	

}
