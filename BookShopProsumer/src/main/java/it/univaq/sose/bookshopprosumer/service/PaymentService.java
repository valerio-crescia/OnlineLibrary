package it.univaq.sose.bookshopprosumer.service;



import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.ws.Response;

import it.univaq.sose.bookshopprosumer.callback.PayCallback;
import it.univaq.sose.paymentservice.api.Pay;
import it.univaq.sose.paymentservice.api.PayRequest;
import it.univaq.sose.paymentservice.api.PayResponse;
import it.univaq.sose.paymentservice.api.PaymentSOAPApiImplService;
import it.univaq.sose.paymentservice.api.PaymentSoapApi;

public class PaymentService {
	
	private static PaymentService INSTANCE;
	
	private static final String SELLER_REFERENCE = "librerie1234";
	
	private PaymentService() {}
	
	public static PaymentService getInstace() {
		if(INSTANCE == null) {
			INSTANCE = new PaymentService();
		}
		return INSTANCE;
	}
	
	public String pay(String cardUserInformation, String cardNumber, int cardSecretCode, Double amount) throws InterruptedException, ExecutionException {
	PaymentSOAPApiImplService service = new PaymentSOAPApiImplService();
	PaymentSoapApi port = service.getPaymentSOAPApiImplPort();
	
	PayRequest request = new PayRequest();
	request.setSellerReference(SELLER_REFERENCE);
	request.setCardNumber(cardNumber);
	request.setCardUserInformation(cardUserInformation);
	request.setCardSecretCode(cardSecretCode);
	request.setAmount(amount);
	
	Pay pay = new Pay();
	pay.setPayRequest(request);
	
	Response<PayResponse> response = port.payAsync(pay);
	PayResponse payResponse = response.get();
	
	return payResponse.getTransactionReferenceNumber();
	
	}
	
	public Future<?> payCallback(PayCallback callback,String cardUserInformation, String cardNumber, int cardSecretCode, Double amount){
		PaymentSOAPApiImplService service = new PaymentSOAPApiImplService();
		PaymentSoapApi port = service.getPaymentSOAPApiImplPort();
		
		PayRequest request = new PayRequest();
		request.setSellerReference(SELLER_REFERENCE);
		request.setCardNumber(cardNumber);
		request.setCardUserInformation(cardUserInformation);
		request.setCardSecretCode(cardSecretCode);
		request.setAmount(amount);
		
		Pay pay = new Pay();
		pay.setPayRequest(request);
		
		return port.payAsync(pay,callback);
	}
	

}
