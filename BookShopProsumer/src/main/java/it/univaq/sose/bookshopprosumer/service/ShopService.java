package it.univaq.sose.bookshopprosumer.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import it.univaq.sose.bookshopprosumer.callback.BookDisponibilityCallback;
import it.univaq.sose.bookshopprosumer.callback.CheckLoginCallback;
import it.univaq.sose.bookshopprosumer.callback.PayCallback;
import it.univaq.sose.bookshopprosumer.callback.SellCallback;
import it.univaq.sose.bookshopprosumer.callback.ShippingCallback;
import it.univaq.sose.bookshopprosumer.dto.RequestBuyDTO;
import it.univaq.sose.bookshopprosumer.model.Order;
import it.univaq.sose.bookshopprosumer.model.Shipment;
import it.univaq.sose.bookshopprosumer.repository.OrderRepository;

public class ShopService {

	private static ShopService INSTANCE;

	public static synchronized ShopService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ShopService();
		}
		return INSTANCE;

	}

	public void buyBook(RequestBuyDTO request) throws ServiceException, InterruptedException, ExecutionException {
		AuthService authService = AuthService.getInstance();
		BookService bookservice = BookService.getInstance();
		PaymentService paymentService = PaymentService.getInstace();
		ShippingService shippingService = ShippingService.getInstance();
		OrderService orderService = OrderService.getInstance();

		CheckLoginCallback loginCallback = new CheckLoginCallback();
		BookDisponibilityCallback bookCallback = new BookDisponibilityCallback();

		Future<?> bookDisponibilityCall = bookservice.checkBookDisponibilityCallback(bookCallback, request.getBookId());
		Future<?> isLoggedCall = authService.checkLoginCallback(loginCallback, request.getJwt());

		while (!(isLoggedCall.isDone() && bookDisponibilityCall.isDone())) {

		}

		if (!loginCallback.isLogged()) {
			System.out.print(isLoggedCall.isDone());
			throw new ServiceException("Utente non loggato");
		}

		if (!bookCallback.isbookDisponibility()) {
			throw new ServiceException("Libro non disponibile");
		}
		// paga
		PayCallback payCallback = new PayCallback();

		Future<?> payCall = paymentService.payCallback(payCallback, request.getCardHolder(), request.getCardNumber(),
				request.getCardSecretCode(), request.getAmount());

		while (!(payCall.isDone())) {
			
		}
		
		if(payCallback.getTransactionReferenceNumber()==null) {
			throw new ServiceException("Transazione errata");
		}
		
		String trn = payCallback.getTransactionReferenceNumber();
		// sell and shipping
		SellCallback sellCallback = new SellCallback();
		ShippingCallback shippingCallback = new ShippingCallback();

		Future<?> sellCall = bookservice.sellBookCallBack(sellCallback, request.getBookId());
		Future<?> shippingCall = shippingService.shippingWithCallback(shippingCallback, request.getAddress(),
				request.getRecipient(), request.getWeight());

		while (!(sellCall.isDone() && shippingCall.isDone())) {

		}

		if (!sellCallback.isSell()) {
			throw new ServiceException("Errore sell");
		}
		Shipment shipment = shippingCallback.getShipment();
		// save order
		orderService.saveOrder(request, shipment, trn);

	}

}
