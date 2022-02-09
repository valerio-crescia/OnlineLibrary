package it.univaq.sose.bookservice.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.univaq.sose.bookservice.domain.Book;
import it.univaq.sose.bookservice.domain.Review;
import it.univaq.sose.bookservice.dto.BookAndReviews;

@Path("/books")
public interface BookServiceApi {
	
	//***************************************************************************************************/
	@Operation(operationId = "getbooks", description = "Get all books", responses = {
			@ApiResponse(description = "List of books", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = Book.class))),
					@Content(mediaType = MediaType.APPLICATION_XML, array = @ArraySchema(schema = @Schema(implementation = Book.class))), })

	})

	@GET
	public List<Book> getBooks();
	
	//***************************************************************************************************/
	
	@Operation(operationId = "getbookAndReviews", description = "getBookAndReviews", responses = {
			@ApiResponse(description = "Book and Reviews", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = BookAndReviews.class)),
					@Content(mediaType = MediaType.APPLICATION_XML, schema = @Schema(implementation = BookAndReviews.class)), })

	})

	@GET
	@Path("/reviews/{id}")
	public BookAndReviews getBookAndReviews(@PathParam("id") Integer id);
	
	
	//***************************************************************************************************/
	@Operation(operationId = "getbookid", description = "Retrive all books",
			 responses = {
					@ApiResponse(description = "List of books", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Book.class)),
							@Content(mediaType = MediaType.APPLICATION_XML, schema = @Schema(implementation = Book.class)) }) }

	)
	@GET
	@Path("/{id}")
	public Book getBook(@PathParam("id") Integer id);
	
	//***************************************************************************************************/
	@Operation(operationId = "reviews", description = "Retrive all reviews of book id",
			 responses = {
					@ApiResponse(description = "List of reviews", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = Review.class))),
							@Content(mediaType = MediaType.APPLICATION_XML, array = @ArraySchema(schema = @Schema(implementation = Review.class))) }) }

	)

	@GET
	@Path("/{id}/reviews")
	public List<Review> geReviews(@PathParam("id") Integer id);
	//***************************************************************************************************/
	@Operation(operationId = "bookdisponibility", description = "Book is disponibility",
			 responses = {
					@ApiResponse(description = "List of reviews", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = String.class)),
							@Content(mediaType = MediaType.APPLICATION_XML, schema = @Schema(implementation = String.class)) }) }

	)

	@GET
	@Path("/{id}/disponibility")
	public String checkBookDisponibility(@PathParam("id") Integer id);
	
	//***************************************************************************************************/
	@Operation(operationId = "sellbook", description = "Decrease number of book copy ", responses = {
			@ApiResponse(description = "Check if book is diponible", content = {
					@Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = String.class)),
					@Content(mediaType = MediaType.APPLICATION_XML, schema = @Schema(implementation = String.class)) }) }

)

	@GET
	@Path("/{id}/sell")
	public String sell(@PathParam("id") Integer id);
	

}