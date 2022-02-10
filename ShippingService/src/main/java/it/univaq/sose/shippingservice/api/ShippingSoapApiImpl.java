package it.univaq.sose.shippingservice.api;

import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;


import it.univaq.sose.shippingservice.domain.Shipment;
import it.univaq.sose.shippingservice.dto.CreateShippingRequest;
import it.univaq.sose.shippingservice.dto.CreateShippingResponse;
import it.univaq.sose.shippingservice.service.ShippingService;

public class ShippingSoapApiImpl implements ShippingSoapApi {
	private ShippingService service = ShippingService.getInstance();
	
	@UseAsyncMethod
	public Shipment createShipping(final CreateShippingRequest request) {
		System.out.println("ShippingSoap - createShipping(" + request.toString() + ")");
		return service.addShippment(request);
	}

	public Response<CreateShippingResponse> createShippingAsync(final CreateShippingRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public Future<?> createShippingAsync(final CreateShippingRequest request, final AsyncHandler<CreateShippingResponse> asyncHandler) {
		final ServerAsyncResponse<CreateShippingResponse> asyncResponse = new ServerAsyncResponse<CreateShippingResponse>();
		new Thread() {
			public void run() {
				CreateShippingResponse response = new CreateShippingResponse();
				
				response.setShipment(service.addShippment(request));
				
				asyncResponse.set(response);
				asyncHandler.handleResponse(asyncResponse);
				
			}
		}.start();
		return asyncResponse;
	}

}
