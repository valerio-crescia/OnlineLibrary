package it.univaq.sose.bookservice.business;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.xml.ws.Response;


import it.univaq.sose.bookservice.domain.Book;
import it.univaq.sose.bookservice.domain.Review;
import it.univaq.sose.bookservice.dto.BookAndReviews;
import it.univaq.sose.bookservice.repository.BookRepository;
import it.univaq.sose.reviewservice.api.GetReviewsByBook;
import it.univaq.sose.reviewservice.api.GetReviewsByBookResponse;
import it.univaq.sose.reviewservice.api.Message;
import it.univaq.sose.reviewservice.api.MessageImplService;

public class BookService {
	private static BookService INSTANCE;
	
	private static BookRepository repository = BookRepository.getInstance();
	
	
	
	private BookService() {};
	
	public synchronized static BookService getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new BookService();
		}
		return INSTANCE;
	}
	
	public List<Book> getBooks(){
		return repository.getBooks();
	}
	
	public Book getBook(Integer id) throws BusinessException  {
		return repository.getBook(id);
	}
	
	public void sellBook(Integer id) throws BusinessException  {
		System.out.println(id);
		Book book = repository.getBook(id);
		System.out.println(book.toString());
		if(book.getNumeroCopieDisponibili() > 0) {
			book.setNumeroCopieDisponibili(book.getNumeroCopieDisponibili() - 1 );
			repository.updateBook(book);
		}else {
			throw new BusinessException("Error Disponiblity");
		}
		
	}
	public void getBookDisponibility(Integer id) throws BusinessException  {
		Book book = repository.getBook(id);
		if(book.getNumeroCopieDisponibili() == 0) {
			throw new BusinessException("Error Disponiblity");
		}
	}
	
	public BookAndReviews getBookandReviews(Integer id) throws BusinessException, InterruptedException, ExecutionException  {
	
		BookAndReviews bookAndReviews = new BookAndReviews();
		// get the book
		Book book = repository.getBook(id);
		
		MessageImplService service = new MessageImplService();
		Message port = service.getMessageImplPort();
		
		GetReviewsByBook request = new GetReviewsByBook();
		request.setIdBook(id);

		//System.out.println(formatter.format(new Date()) + " - invoking sendMessageWithReturnAsync(request) ...");
		Response<GetReviewsByBookResponse> response = port.getReviewsByBookAsync(request);
		while (!response.isDone()) {
		
		}
		GetReviewsByBookResponse reply = response.get();
		// set the book
		bookAndReviews.setBook(book);
		List<Review> reviews = Utils.objectMapperToListModelReview(reply.getReviews());
		//set the reviews
		bookAndReviews.setReviews(reviews);
		return bookAndReviews;
	
	}

}
