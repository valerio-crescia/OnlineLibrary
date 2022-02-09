package it.univaq.sose.bookshopprosumer.service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.ws.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univaq.sose.bookshopprosumer.callback.ShippingCallback;
import it.univaq.sose.bookshopprosumer.model.Shipment;
import it.univaq.sose.shippingservice.api.CreateShipping;
import it.univaq.sose.shippingservice.api.CreateShippingRequest;
import it.univaq.sose.shippingservice.api.CreateShippingResponse;
import it.univaq.sose.shippingservice.api.ShippingSoapApi;
import it.univaq.sose.shippingservice.api.ShippingSoapApiImplService;

public class ShippingService {

	private static ShippingService INSTANCE;

	private ShippingService() {
	}

	public static ShippingService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ShippingService();
		}
		return INSTANCE;
	}

	public Shipment makeCall(String adress, String recipient, Double weight)
			throws InterruptedException, ExecutionException {

		ShippingSoapApiImplService service = new ShippingSoapApiImplService();
		ShippingSoapApi port = service.getShippingSoapApiImplPort();

		CreateShippingRequest request = new CreateShippingRequest();
		request.setUserInfomation(recipient);
		request.setAddress(adress);
		request.setObjectWeight(weight);

		CreateShipping messageShipping = new CreateShipping();
		messageShipping.setCreateShippingRequest(request);

		Response<CreateShippingResponse> response = port.createShippingAsync(messageShipping);

		CreateShippingResponse responseArrived = response.get();
		Shipment shipment = objectMapperToShipment(responseArrived.getShipment());

		return shipment;

	}

	public Future<?> shippingWithCallback(ShippingCallback callback, String adress, String recipient, Double weight)
			throws InterruptedException, ExecutionException {

		ShippingSoapApiImplService service = new ShippingSoapApiImplService();
		ShippingSoapApi port = service.getShippingSoapApiImplPort();

		CreateShippingRequest request = new CreateShippingRequest();
		request.setUserInfomation(recipient);
		request.setAddress(adress);
		request.setObjectWeight(weight);

		CreateShipping messageShipping = new CreateShipping();
		messageShipping.setCreateShippingRequest(request);

		return port.createShippingAsync(messageShipping, callback);
	}

	private static it.univaq.sose.bookshopprosumer.model.Shipment objectMapperToShipment(
			it.univaq.sose.shippingservice.api.Shipment shipment) {
		ObjectMapper mapper = new ObjectMapper();
		it.univaq.sose.bookshopprosumer.model.Shipment shipmentModel = mapper.convertValue(shipment,
				it.univaq.sose.bookshopprosumer.model.Shipment.class);
		return shipmentModel;
	}

}
