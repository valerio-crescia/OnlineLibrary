package it.univaq.sose.paymentservice.repository;

import java.util.ArrayList;
import java.util.List;

import it.univaq.sose.paymentservice.domain.Payment;

public class PaymentRepository {
	private static List<Payment> payments ;
	
	private static PaymentRepository INSTANCE;
	
	private static int count = 1;
	
	private PaymentRepository() {}
	
	public synchronized static PaymentRepository getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PaymentRepository();
			payments = new ArrayList<Payment>();
		}
		return INSTANCE;
	}
	
	public Payment addPayment(Payment payment) {
		
		payment.setIdPayment(count);
		payments.add(payment);
		count++;
		return payment;
		
	}
	public Payment getPaymentById(int id) throws RepositoryException {
		for(Payment payment : payments) {
			if(payment.getIdPayment() == id) {
				return payment;
			}
		}
		throw new RepositoryException("Id not found");
	}
	
	public Payment getPaymentByTRN(String TRN) throws RepositoryException{
		for(Payment payment : payments) {
			if(payment.getTransactionReferenceNumber().equals(TRN)) {
				return payment;
			}
		}
		throw new RepositoryException("TRN not found");
		
	}
	
	
	
}
