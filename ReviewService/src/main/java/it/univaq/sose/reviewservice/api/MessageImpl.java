package it.univaq.sose.reviewservice.api;

import java.util.List;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;

import it.univaq.sose.reviewservice.domain.Review;
import it.univaq.sose.reviewservice.dto.GetReviewsByBookResponse;
import it.univaq.sose.reviewservice.service.ReviewService;

public class MessageImpl implements Message {
	private ReviewService reviewService = new ReviewService();

	@Override
	@UseAsyncMethod
	public List<Review> getReviewsByBook(int idBook) {
		System.out.println("MessageImpl - getReviewsByBook(" + idBook +")");
		List<Review> reviews = reviewService.getBookReviews(idBook);
		System.out.println(reviews);
		return reviews;
	}

	@Override
	public Response<GetReviewsByBookResponse> getReviewsByBookAsync(int idbook) {
		System.out.println("MessageImpl - getReviewsByBookAsync(" + idbook +")");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<?> getReviewsByBookAsync(int idbook, AsyncHandler<GetReviewsByBookResponse> asyncHandler) {
		System.out.println("MessageImpl - getReviewsByFilmAsync(" + idbook + asyncHandler +")");
		final ServerAsyncResponse<GetReviewsByBookResponse> asyncResponse = new ServerAsyncResponse<GetReviewsByBookResponse>();
		new Thread() {
			public void run() {
				GetReviewsByBookResponse response = new GetReviewsByBookResponse();
				
				List<Review> reviews = reviewService.getBookReviews(idbook);
				
				response.setReviews(reviews);
				
				asyncResponse.set(response);
				asyncHandler.handleResponse(asyncResponse);
				
			}
		}.start();
		return asyncResponse;
	}


}
