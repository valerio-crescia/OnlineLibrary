package it.univaq.sose.paymentservice.api;

import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;

import it.univaq.sose.paymentservice.dto.PayRequest;
import it.univaq.sose.paymentservice.dto.PayResponse;
import it.univaq.sose.paymentservice.service.PaymentService;

public class PaymentSOAPApiImpl implements PaymentSoapApi {
	private PaymentService service = PaymentService.getInstance();

	@UseAsyncMethod
	public String pay(final PayRequest request) {
		String TRN = service.pay(request);
		return TRN;
	}

	public Response<PayResponse> payAsync(final PayRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public Future<?> payAsync(final PayRequest request, final AsyncHandler<PayResponse> asyncHandler) {
		System.out.println("MessageImpl - getReviewsByFilmAsync(" + request.toString() + asyncHandler + ")");
		final ServerAsyncResponse<PayResponse> asyncResponse = new ServerAsyncResponse<PayResponse>();
		new Thread() {
			public void run() {
				PayResponse response = new PayResponse();

				response.setTransactionReferenceNumber(service.pay(request));

				asyncResponse.set(response);
				asyncHandler.handleResponse(asyncResponse);

			}
		}.start();
		return asyncResponse;
	}

}
