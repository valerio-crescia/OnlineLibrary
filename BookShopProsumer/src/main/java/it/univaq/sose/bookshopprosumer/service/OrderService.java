package it.univaq.sose.bookshopprosumer.service;

import it.univaq.sose.bookshopprosumer.dto.RequestBuyDTO;
import it.univaq.sose.bookshopprosumer.model.Order;
import it.univaq.sose.bookshopprosumer.model.Shipment;
import it.univaq.sose.bookshopprosumer.repository.OrderRepository;

public class OrderService {

	private static OrderService INSTANCE;
	
	
	private OrderService(){ }
	
	public static OrderService getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new OrderService();
		}
		return INSTANCE;
	}
	
	public void saveOrder(RequestBuyDTO request, Shipment shipment, String trn) {
		OrderRepository orderRepository = OrderRepository.getInstance();
		Order order = new Order();
		order.setUserId(request.getUserId());
		order.setRecipient(request.getRecipient());
		order.setShipmentId(shipment.getId());
		order.setTRN(trn);
		order.setAmount(request.getAmount());
		
		orderRepository.saveOrder(order);
		
	}
	
}
