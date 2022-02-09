package it.univaq.sose.reviewservice.dto;

import java.util.List;

import it.univaq.sose.reviewservice.domain.Review;

public class GetReviewsByBookResponse {

	private List<Review> reviews;

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	
 }
