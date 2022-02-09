package it.univaq.sose.reviewservice.service;

import java.util.List;

import it.univaq.sose.reviewservice.domain.Review;
import it.univaq.sose.reviewservice.repository.ReviewRepository;

public class ReviewService {
	
	private ReviewRepository repository = ReviewRepository.getInstance();
	
	public List<Review> getBookReviews(int idFilm){
		return repository.getBookReview(idFilm);
	}

}
