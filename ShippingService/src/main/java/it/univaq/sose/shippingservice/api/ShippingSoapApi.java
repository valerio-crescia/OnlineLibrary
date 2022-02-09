package it.univaq.sose.shippingservice.api;

import java.util.concurrent.Future;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

import it.univaq.sose.shippingservice.domain.Shipment;
import it.univaq.sose.shippingservice.dto.CreateShippingRequest;
import it.univaq.sose.shippingservice.dto.CreateShippingResponse;

@WebService
public interface ShippingSoapApi {
	
	@WebMethod
	@ResponseWrapper(localName="createShippingResponse", className = "it.univaq.sose.shippingservice.dto.CreateShippingResponse")
	public Shipment createShipping(@WebParam(name="createShippingRequest") final  CreateShippingRequest request);
	
	@WebMethod
	@ResponseWrapper(localName="createShippingResponse", className = "it.univaq.sose.shippingservice.dto.CreateShippingResponse")
	public Response<CreateShippingResponse> createShippingAsync(@WebParam(name="createShippingRequest")final CreateShippingRequest request);
	
	@WebMethod
	@ResponseWrapper(localName="createShippingResponse", className = "it.univaq.sose.shippingservice.dto.CreateShippingResponse")
	public Future<?> createShippingAsync(@WebParam(name="createShippingRequest")final CreateShippingRequest request, final AsyncHandler<CreateShippingResponse> asyncHandler);
	
}
