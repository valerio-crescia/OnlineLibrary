package it.univaq.sose.bookshopprosumer.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.univaq.sose.bookshopprosumer.dto.RequestBuyDTO;

@Path("/buy")
public interface BookShopApi {
	@Operation(operationId = "buy", description = "Buy book", responses = { @ApiResponse(description = "Ok", content = {
			@Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = String.class)),
			@Content(mediaType = MediaType.APPLICATION_XML, schema = @Schema(implementation = String.class)), })

	})

	@POST
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json" })
	public boolean buy(@RequestBody(description = "Cazzzozozozzoo", required = true, content = {
			@Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = RequestBuyDTO.class)),
			@Content(mediaType = MediaType.APPLICATION_XML, schema = @Schema(implementation = RequestBuyDTO.class))

	}) RequestBuyDTO dto);
}
