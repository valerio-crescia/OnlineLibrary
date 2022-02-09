package it.univaq.sose.bookservice.api;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import it.univaq.sose.bookservice.business.BookService;
import it.univaq.sose.bookservice.business.BusinessException;
import it.univaq.sose.bookservice.business.ReviewService;
import it.univaq.sose.bookservice.domain.Book;
import it.univaq.sose.bookservice.domain.Review;
import it.univaq.sose.bookservice.dto.BookAndReviews;

public class BookServiceApiImpl implements BookServiceApi {

	private BookService service = BookService.getInstance();

	private ReviewService reviewService = ReviewService.getInstance();

	@Override
	public Book getBook(Integer id) throws WebApplicationException {
		try {
			return service.getBook(id);
		} catch (BusinessException e) {
			throw new WebApplicationException(Status.NO_CONTENT);
		}
	}

	@Override
	public List<Book> getBooks() {
		return service.getBooks();
	}

	@Override
	public List<Review> geReviews(Integer id) {
		try {
			return reviewService.getReview(id);
		} catch (InterruptedException | ExecutionException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public BookAndReviews getBookAndReviews(Integer id) {
		try {
			return service.getBookandReviews(id);
		}catch (BusinessException e){
			throw new WebApplicationException(Status.NO_CONTENT);
		}catch(InterruptedException | ExecutionException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public String checkBookDisponibility(Integer id) {
		try {
			service.getBookDisponibility(id);
			return "true";
		}catch (BusinessException e){
			throw new WebApplicationException(Status.NO_CONTENT);
		}
	}

	@Override
	public String sell(Integer id) {
		try {
			service.sellBook(id);
			return "true";
		}catch (BusinessException e){
			System.out.println(e.getMessage());
			throw new WebApplicationException(Status.NO_CONTENT);
		}
		
	}

}
