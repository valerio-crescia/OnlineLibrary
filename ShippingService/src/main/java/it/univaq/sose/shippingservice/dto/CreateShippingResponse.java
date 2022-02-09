package it.univaq.sose.shippingservice.dto;

import it.univaq.sose.shippingservice.domain.Shipment;

public class CreateShippingResponse {
	
	private Shipment shipment;

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	

}
