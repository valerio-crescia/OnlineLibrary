package it.univaq.sose.authservice.api.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Jwt")
public class JwtDto {
	private String  idToken;
	private Date expiresIn;
	private String userId;
	
	
	public JwtDto() {
		super();
	}
	public JwtDto(String idToken, Date expiresIn, String userId) {
		super();
		this.idToken = idToken;
		this.expiresIn = expiresIn;
		this.userId = userId;
	}
	public String getIdToken() {
		return idToken;
	}
	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
	public Date getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Date expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	

}
