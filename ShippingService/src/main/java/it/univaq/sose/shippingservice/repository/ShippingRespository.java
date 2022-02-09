package it.univaq.sose.shippingservice.repository;

import java.util.ArrayList;
import java.util.List;

import it.univaq.sose.shippingservice.domain.Shipment;


public class ShippingRespository {
	
	private static List<Shipment> shipments;
	
	private static int count = 1;
	
	private static ShippingRespository shippingRespository;
	
	private ShippingRespository() {}
	
	public static synchronized ShippingRespository getInstance() {
		if(shippingRespository == null) {
			shippingRespository = new ShippingRespository();
			shipments = new ArrayList<Shipment>();
		}
		return shippingRespository;
	}
	
	public synchronized Shipment saveShipment(Shipment shipment) {
		shipment.setId(count);
		shipments.add(shipment);
		count++;
		return shipment;
	}
	
	public synchronized List<Shipment> getAllShipment(Shipment shipment) {
		return shipments;
	}
	
	public synchronized Shipment getAllShipment(int id) {
		for(Shipment shipment : shipments) {
			if(shipment.getId() == id) {
				return shipment;
			}
		}
		return null;
	}

}
