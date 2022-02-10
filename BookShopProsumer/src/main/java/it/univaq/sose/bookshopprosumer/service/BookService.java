package it.univaq.sose.bookshopprosumer.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import it.univaq.sose.bookshopprosumer.callback.BookDisponibilityCallback;
import it.univaq.sose.bookshopprosumer.callback.SellCallback;

public class BookService {
	
	private static BookService INSTANCE;
	
	private BookService() {}
	
	private static final String URL_BOOK_DISPONIBILITY = "http://localhost:8080/BookServiceProsumer/rest/books/%s/disponibility";
	private static final String URL_BOOK_SELL = "http://localhost:8080/BookServiceProsumer/rest/books/%s/sell";
	
	public static synchronized BookService getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new BookService();
		}
		return INSTANCE;
		
	}
	
	public Boolean checkBookDisponibility(Integer id) {
		String url = String.format(URL_BOOK_DISPONIBILITY, String.valueOf(id));
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) {
				System.out.println("Success");
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
	
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				// print result
				System.out.println(response.toString());
				return(response.toString().equals("true"));
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return false;
		
	}
	public Future<?> checkBookDisponibilityCallback(BookDisponibilityCallback callback,Integer id) {
		String url = String.format(URL_BOOK_DISPONIBILITY, String.valueOf(id));
		Client client = ClientBuilder.newClient();
		
		//Make callback
		return client.target(url).request().async().get(callback);
		
	}
	
	
	public Boolean sellBook(Integer id) {
		String url = String.format(URL_BOOK_SELL, String.valueOf(id));
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) {
				System.out.println("Success");
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
	
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				// print result
				System.out.println(response.toString());
				return(response.toString().equals("true"));
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return false;
		
	}
	public Future<?> sellBookCallBack(SellCallback callback,Integer id) {
		String url = String.format(URL_BOOK_SELL, String.valueOf(id));
		Client client = ClientBuilder.newClient();
		
		//Make callback
		return client.target(url).request().async().get(callback);
		
	}
	

}
