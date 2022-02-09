package it.univaq.sose.authservice.api;

import javax.ws.rs.WebApplicationException;

import it.univaq.sose.authservice.api.dto.JwtDto;
import it.univaq.sose.authservice.api.dto.UserDto;
import it.univaq.sose.authservice.repository.RepositoryException;
import it.univaq.sose.authservice.service.AuthService;
import it.univaq.sose.authservice.service.ServiceException;

public class AuthApiServiceImpl implements AuthApiService {

	@Override
	public JwtDto login(UserDto user) {
		try {
			return AuthService.login(user);
		} catch (ServiceException | RepositoryException e) {
			throw new WebApplicationException(401);

		} catch (Exception e) {
			throw new WebApplicationException(500);
		}

	}

	@Override
	public Boolean checkJwt(String Jwt) {
		System.out.println(Jwt);
		if (AuthService.checkJwt(Jwt)){
			return true;
		}else {
			throw new WebApplicationException(401);
		}
		
	}

}
