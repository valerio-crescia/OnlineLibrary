package it.univaq.sose.bookshopprosumer.callback;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;

public class BookDisponibilityCallback implements InvocationCallback<Response>{
	private Boolean bookDisponibility = false;

	public void completed(Response response)  {
		if (response.getStatus() == 200) {
			String message = response.readEntity(String.class);
			if("true".equals(message)) {
				bookDisponibility = true;
			}
		} else {
			System.err.println("Request error: " + response.getStatus());
		}
		
	}

	public void failed(Throwable throwable) {
		throwable.printStackTrace();
	}
	
	public Boolean isbookDisponibility() {
		return bookDisponibility;
	}
}
