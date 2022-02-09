package it.univaq.sose.paymentservice.service;

import java.util.UUID;

import it.univaq.sose.paymentservice.domain.Payment;
import it.univaq.sose.paymentservice.dto.PayRequest;
import it.univaq.sose.paymentservice.repository.PaymentRepository;
import it.univaq.sose.paymentservice.repository.RepositoryException;

public class PaymentService {
	private static PaymentService INSTANCE;
	
	private static PaymentRepository repo = PaymentRepository.getInstance();
	
	private PaymentService() {}
	
	public static synchronized PaymentService getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PaymentService();
		}
		return INSTANCE;
	}
	
	public synchronized String pay(PayRequest request) {
		String unique = UUID.randomUUID().toString();
		//I Make unique string for simulating Transaction Reference Number
		Payment payment = new Payment();
		
		payment.setTransactionReferenceNumber(unique);
		payment.setCardNumber(request.getCardNumber());
		payment.setCardSecretCode(request.getCardSecretCode());
		payment.setAmount(request.getAmount());
		payment.setCardUserInformation(request.getCardUserInformation());
		payment.setSellerReference(request.getSellerReference());
		
		payment = repo.addPayment(payment);
		System.out.println(payment.toString());
		return unique;
		
	}
	
	// TODO dovremo fare qualche mini funzione per provare che il tizio non ha i soldi
	

}
