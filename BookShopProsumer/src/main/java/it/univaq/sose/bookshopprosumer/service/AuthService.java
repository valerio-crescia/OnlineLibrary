package it.univaq.sose.bookshopprosumer.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import it.univaq.sose.bookshopprosumer.callback.CheckLoginCallback;


public class AuthService {
	
	private static AuthService INSTANCE;
	
	private static String URLJWT = "http://localhost:8080/AuthService1/rest/login/";
	
	private AuthService() {}
	
	public static synchronized AuthService getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new AuthService();
		}
		return INSTANCE;
	}
	
	public Boolean checkLogin(String jwt)  {
		try {
			String url = URLJWT + jwt;
			URL obj = new URL(url.toString());
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return false;
		
	}
	
	public Boolean checkLogin1(String jwt) throws InterruptedException, ExecutionException  {
		String url = URLJWT + jwt;
		Client client = ClientBuilder.newClient();
		
		//Make callback
		Future<Response> futureResponse = client.target(url).request().async().get();
		
		while (!futureResponse.isDone()) {
			// client does some work
		}

		Response response = futureResponse.get();

		String value = response.readEntity(String.class);
		if(response.getStatus() == 200) {
			return true;
		}
		return false;
		
	}
	public Future<?> checkLoginCallback(CheckLoginCallback callback,String jwt) throws InterruptedException, ExecutionException  {
		String url = URLJWT + jwt;
		Client client = ClientBuilder.newClient();
		
		//Make callback
		return client.target(url).request().async().get(callback);
		
	}
	
	

}
