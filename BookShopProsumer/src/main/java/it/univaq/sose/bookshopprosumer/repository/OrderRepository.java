package it.univaq.sose.bookshopprosumer.repository;

import java.util.ArrayList;
import java.util.List;

import it.univaq.sose.bookshopprosumer.model.Order;

public class OrderRepository {
	private static OrderRepository INSTANCE;
	
	private static List<Order> orders = new ArrayList<Order>();
	
	private static int count = 1;
	
	private OrderRepository() {}
	
	public static OrderRepository getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new OrderRepository();
		
		}
		return INSTANCE;
	}
	
	public void saveOrder(Order order) {
		order.setId(this.count);
		orders.add(order);
		System.out.println(order);
		count++;
	}

}
