package it.univaq.sose.bookservice.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import it.univaq.sose.bookservice.domain.Book;
import it.univaq.sose.bookservice.domain.Review;

@XmlRootElement(name="BookAndReviews")
public class BookAndReviews {
	
	private Book book;
	private List<Review> reviews;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	@Override
	public String toString() {
		return "BookAndReviews [book=" + book + ", review=" + reviews + "]";
	}
	
	

}
