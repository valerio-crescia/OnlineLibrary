package it.univaq.sose.authservice.api;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class SecurityKey {
	public static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
}
