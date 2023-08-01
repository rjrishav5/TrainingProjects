package com.rishav.javamini.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rishav.javamini.model.AccountInfo;

public interface FailureDao extends JpaRepository<AccountInfo, Integer> {
	

	List<AccountInfo> findByAccountNumberAndStatus(String accountNumber, String status);

}
