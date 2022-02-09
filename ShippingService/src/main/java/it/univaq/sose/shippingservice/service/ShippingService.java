package it.univaq.sose.shippingservice.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import it.univaq.sose.shippingservice.domain.Shipment;
import it.univaq.sose.shippingservice.dto.CreateShippingRequest;
import it.univaq.sose.shippingservice.repository.ShippingRespository;

public class ShippingService {
	
	private static ShippingService instance;
	
	private static ShippingRespository repo = ShippingRespository.getInstance();
	
	public static ShippingService getInstance() {
		if(instance == null) {
			instance = new ShippingService();
		}
		return instance;
	}
	public synchronized Shipment addShippment(CreateShippingRequest request) {
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime startShipping = now.plusDays(1);
		Date dateStartingTime = Date.from(startShipping.atZone(ZoneId.systemDefault()).toInstant());
		
		LocalDateTime arriveShipping = now.plusDays(2);
		Date arriveShippingDate = Date.from(arriveShipping.atZone(ZoneId.systemDefault()).toInstant());
		
		
		Shipment shipment = new Shipment();
		
		shipment.setObjectWeight(request.getObjectWeight());
		shipment.setShippingStart(dateStartingTime);
		shipment.setShippingArrives(arriveShippingDate);
		shipment.setAddress(request.getAddress());
		shipment.setUserInformation(request.getUserInfomation());
		
		return repo.saveShipment(shipment);
	}
	
	
}
