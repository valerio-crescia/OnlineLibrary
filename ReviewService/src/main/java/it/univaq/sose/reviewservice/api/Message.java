package it.univaq.sose.reviewservice.api;

import java.util.List;
import java.util.concurrent.Future;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

import it.univaq.sose.reviewservice.domain.Review;
import it.univaq.sose.reviewservice.dto.GetReviewsByBookResponse;



@WebService
public interface Message {

	@WebMethod
	@ResponseWrapper(localName="getReviewsByBookResponse" , className="it.univaq.sose.reviewservice.dto.GetReviewsByBookResponse")
	public List<Review> getReviewsByBook(@WebParam(name="idBook") int idBook);
	
	@WebMethod
	@ResponseWrapper(localName="getReviewsByBookResponse" , className="it.univaq.sose.reviewservice.dto.GetReviewsByBookResponse")
	public Response<GetReviewsByBookResponse> getReviewsByBookAsync(@WebParam(name="idBook") int idBook );
	
	@WebMethod
	@ResponseWrapper(localName="getReviewsByFilmResponse" , className="it.univaq.sose.reviewservice.dto.GetReviewsByBookResponse")
	public Future<?> getReviewsByBookAsync(@WebParam(name="idBook") int idBook, AsyncHandler<GetReviewsByBookResponse> asyncHandler);
	
}
