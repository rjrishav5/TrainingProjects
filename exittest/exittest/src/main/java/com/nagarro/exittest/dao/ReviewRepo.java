package com.nagarro.exittest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.exittest.model.Review;

public interface ReviewRepo extends JpaRepository<Review,Integer>{
	
	@Query("from Review where productCode=?1")
	List<Review> findByReview(int productCode);

}
