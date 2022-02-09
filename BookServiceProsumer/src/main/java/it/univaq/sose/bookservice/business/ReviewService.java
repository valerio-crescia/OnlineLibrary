package it.univaq.sose.bookservice.business;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.xml.ws.Response;



import it.univaq.sose.reviewservice.api.GetReviewsByBook;
import it.univaq.sose.reviewservice.api.GetReviewsByBookResponse;
import it.univaq.sose.reviewservice.api.Message;
import it.univaq.sose.reviewservice.api.MessageImplService;
import it.univaq.sose.bookservice.domain.Review;

public class ReviewService {
	
	private static ReviewService INSTANCE;
	
	private ReviewService() {
		
	}
	
	public static ReviewService getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ReviewService();
		}
		return INSTANCE;
	}
	
	public List<Review> getReview(int bookId) throws InterruptedException, ExecutionException{
		MessageImplService service = new MessageImplService();
		Message port = service.getMessageImplPort();
		
		GetReviewsByBook request = new GetReviewsByBook();
		request.setIdBook(1);
		Response<GetReviewsByBookResponse> response = port.getReviewsByBookAsync(request);
		
		GetReviewsByBookResponse responseArrived = response.get();
		List<Review> reviews = Utils.objectMapperToListModelReview(responseArrived.getReviews());
		return reviews;
		
	}
	

}
