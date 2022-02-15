package it.univaq.sose.bookshopprosumer.api;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import it.univaq.sose.bookshopprosumer.dto.RequestBuyDTO;
import it.univaq.sose.bookshopprosumer.service.ServiceException;
import it.univaq.sose.bookshopprosumer.service.ShopService;

public class BookShopApiImpl implements BookShopApi {

	private ShopService service = ShopService.getInstance();

	public boolean buy(RequestBuyDTO dto) {
		boolean result = false;
		try {
			service.buyBook(dto);
			result = true;

		} catch (ServiceException e) {
			e.printStackTrace();
			throw new WebApplicationException(e.getMessage(), Status.BAD_REQUEST);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);

		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

}
