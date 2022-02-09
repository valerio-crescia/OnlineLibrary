package it.univaq.sose.authservice.api.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User")
public class UserDto {
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	

}
