package it.univaq.sose.authservice.api;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import it.univaq.sose.authservice.api.dto.JwtDto;
import it.univaq.sose.authservice.api.dto.UserDto;

@Path("/login")
public interface AuthApiService {
	

	@POST
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public JwtDto login(UserDto user) throws Exception;
	
	
	@GET
	@Path("/{jwt}")
	public Boolean checkJwt(@PathParam("jwt") String Jwt);
	

}
