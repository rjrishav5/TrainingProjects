package com.example.demo.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.FeignModel;


@FeignClient(name = "javamini", url = "http://localhost:1235/backendserver2/failure/")
public interface FailureInterface {

	
	
	@GetMapping("{accountnumber}")
	List<FeignModel> getFailureTransactions(@PathVariable String accountnumber);
}
