package com.rishav.javamini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rishav.javamini.model.AccountInfo;
import com.rishav.javamini.service.FailureService;
@RestController
@RequestMapping("/backendserver2/failure")
public class FailreController {
		@Autowired
	    private FailureService failureServices;


		@GetMapping("/{accountnumber}")
		public List<AccountInfo> getTransactions(@PathVariable String accountnumber){
			
			List<AccountInfo> trans = this.failureServices.getTransactions(accountnumber);
			return trans;
			}

}
