package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SuccessModel;


public interface SuccessDao extends JpaRepository<SuccessModel, Long> {
	
	List<SuccessModel> findByAccountNumberAndStatus(String accountNumber, String status);

}
