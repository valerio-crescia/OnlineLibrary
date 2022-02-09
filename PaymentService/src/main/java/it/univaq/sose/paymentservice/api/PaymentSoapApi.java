package it.univaq.sose.paymentservice.api;

import java.util.concurrent.Future;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

import it.univaq.sose.paymentservice.dto.PayRequest;
import it.univaq.sose.paymentservice.dto.PayResponse;

@WebService
public interface PaymentSoapApi {
	
	@WebMethod
	@ResponseWrapper(localName = "paymentResponse" , className ="it.univaq.sose.paymentservice.dto.PayResponse")
	public String pay( @WebParam(name="payRequest") PayRequest request);
	
	@WebMethod
	@ResponseWrapper(localName = "paymentResponse" , className ="it.univaq.sose.paymentservice.dto.PayResponse")
	public Response<PayResponse> payAsync(@WebParam(name="payRequest")PayRequest request);
	
	@WebMethod
	@ResponseWrapper(localName = "paymentResponse" , className ="it.univaq.sose.paymentservice.dto.PayResponse")
	public Future<?> payAsync(@WebParam(name="payRequest") PayRequest request, AsyncHandler<PayResponse> asyncHandler);

}
