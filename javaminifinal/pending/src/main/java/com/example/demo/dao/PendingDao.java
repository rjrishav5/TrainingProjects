package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PendingModel;
//import org.springframework.ws.soap.server.endpoint.annotation.SoapActions;



public interface PendingDao  extends JpaRepository<PendingModel, Long>{
	
	List<PendingModel> findByAccountNumberAndStatus(String accountNumber, String status);

}
