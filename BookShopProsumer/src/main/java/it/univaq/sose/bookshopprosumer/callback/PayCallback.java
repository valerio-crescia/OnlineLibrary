package it.univaq.sose.bookshopprosumer.callback;

import javax.ws.rs.client.InvocationCallback;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import it.univaq.sose.paymentservice.api.PayResponse;

public class PayCallback implements AsyncHandler<PayResponse>{
	// questa è una callback soap
	private String transactionReferenceNumber;

	public void handleResponse(Response<PayResponse> res) {
		try {
			transactionReferenceNumber = res.get().getTransactionReferenceNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getTransactionReferenceNumber() {
		
		return transactionReferenceNumber;
	}

	

}
