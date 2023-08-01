package com.nagarro.exittest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exittest.model.Review;
import com.nagarro.exittest.service.ReviewService;

@RestController
@CrossOrigin("*")
public class ReviewController {
	@Autowired
	private ReviewService service;
	
	
//	This function will let us get all reviews from particular productCode
	@GetMapping("/review/{productCode}")
	public List<Review> getReview(@PathVariable int productCode) {
		return service.getReview(productCode);
	}
	
	
//	This function will let us add new review
	@PostMapping("/addreview")
	public  Review addReview(@RequestBody Review review) {
		return service.saveProduct(review);
		
		
		
//		This function will return the total number of review.
	}
	@GetMapping("/reviewcount")
	public long count() {
		return service.count();
	}
}
