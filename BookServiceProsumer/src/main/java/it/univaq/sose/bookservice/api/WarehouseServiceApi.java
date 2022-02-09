package it.univaq.sose.bookservice.api;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.univaq.sose.bookservice.domain.Book;

@Path("/warehouse")
public interface WarehouseServiceApi {
	
	// Saranno i metodi che serviranno all'bookshop per prendere le copie
	// 

}
