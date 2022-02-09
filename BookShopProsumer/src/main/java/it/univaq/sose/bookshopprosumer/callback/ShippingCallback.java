package it.univaq.sose.bookshopprosumer.callback;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.univaq.sose.bookshopprosumer.model.Shipment;
import it.univaq.sose.shippingservice.api.CreateShippingResponse;

public class ShippingCallback implements AsyncHandler<CreateShippingResponse> {
	private Shipment shipment;

	public void handleResponse(Response<CreateShippingResponse> res) {
		try {
			shipment = objectMapperToShipment(res.get().getShipment());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static it.univaq.sose.bookshopprosumer.model.Shipment objectMapperToShipment(
			it.univaq.sose.shippingservice.api.Shipment shipment) {
		ObjectMapper mapper = new ObjectMapper();
		it.univaq.sose.bookshopprosumer.model.Shipment shipmentModel = mapper.convertValue(shipment,
				it.univaq.sose.bookshopprosumer.model.Shipment.class);
		return shipmentModel;
	}
	
	public Shipment getShipment() {
		return shipment;
	}
	

}
