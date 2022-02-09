package it.univaq.sose.authservice.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import it.univaq.sose.authservice.api.SecurityKey;
import it.univaq.sose.authservice.api.dto.JwtDto;
import it.univaq.sose.authservice.api.dto.UserDto;
import it.univaq.sose.authservice.domain.User;
import it.univaq.sose.authservice.repository.RepositoryException;
import it.univaq.sose.authservice.repository.UserRepository;

public class AuthService {

	public static JwtDto login(UserDto userDto) throws RepositoryException, ServiceException {

		User user = UserRepository.getUserByUsername(userDto.getUsername());

		if (user.getPassword().equals(userDto.getPassword())) {
			return makeJwt(userDto.getUsername(), user.getId());
		} else {
			throw new ServiceException("Wrong password");
		}

	}

	private static JwtDto makeJwt(String username, String userId) {
		JwtDto jwtDto = new JwtDto();
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime nowPlusOneMouth = now.plusMonths(1);
		Date currentDatePlusOneMouths = Date.from(nowPlusOneMouth.atZone(ZoneId.systemDefault()).toInstant());
		String token = Jwts.builder().
				setSubject(username).
				setExpiration(currentDatePlusOneMouths).
				signWith(SecurityKey.key).
				compact();
		
		jwtDto.setIdToken(token);
		jwtDto.setExpiresIn(currentDatePlusOneMouths);
		jwtDto.setUserId(userId);
		return jwtDto;
		
	}

	public static boolean checkJwt(String jwt) {
		try {
			Claims claims = Jwts.parserBuilder().setSigningKey(SecurityKey.key).build().parseClaimsJws(jwt).getBody();
			System.out.println(claims.getSubject());
			return true;

		} catch (JwtException e) {
			return false;
		}
	}

}
