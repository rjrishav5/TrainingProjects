package com.nagarro.exittest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.exittest.dao.ReviewRepo;
import com.nagarro.exittest.model.Review;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepo repository;
	
	public List<Review> getReview(int productCode) {
		return repository.findByReview(productCode);
	}


	public Review saveProduct(Review review) {
		return repository.save(review);
	}
	public long count() {
		return repository.count();
	}

}
