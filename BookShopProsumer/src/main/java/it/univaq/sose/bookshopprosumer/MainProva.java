package it.univaq.sose.bookshopprosumer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import it.univaq.sose.bookshopprosumer.callback.PayCallback;
import it.univaq.sose.bookshopprosumer.callback.ShippingCallback;
import it.univaq.sose.bookshopprosumer.dto.RequestBuyDTO;
import it.univaq.sose.bookshopprosumer.service.AuthService;
import it.univaq.sose.bookshopprosumer.service.BookService;
import it.univaq.sose.bookshopprosumer.service.PaymentService;
import it.univaq.sose.bookshopprosumer.service.ShippingService;
import it.univaq.sose.bookshopprosumer.service.ShopService;

public class MainProva {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//AuthService auth = AuthService.getInstance();
		//BookService service = BookService.getInstance();
		
		//ShippingService service = ShippingService.getInstance();
		//System.out.println(service.send("via di sotto", "valerio", 12.3).toString());
		//PaymentService service = PaymentService.getInstace();
		//System.out.println(service.pay("Valerio Crescia", "2121212121212", 123, 123.23));
		
		
		//System.out.println(auth.checkLogin1("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJpb1VzZXJuYW1lIiwiZXhwIjoxNjQ2MDQ0MzQyfQ.gMdvR-v5ffwxaQQ0CKuSVxHgY0u4EoJ0Lu7hAdBw_WI"));
		//PayCallback callback = new PayCallback();
		
		//ShippingCallback callback = new ShippingCallback();
		
		//Future<?> future = service.payCallback(callback,"Valerio Crescia", "2121212121212", 123, 123.23);
		//Future<?> future = service.shippingWithCallback(callback, "via di sotto", "valerio", 12.3);
		
		//while(!future.isDone()) {
			
		//}
		//System.out.println(callback.getShipment().toString());
		
		ShopService service = ShopService.getInstance();
		
		RequestBuyDTO dto = new RequestBuyDTO();
		
		
		
		

	}
}
