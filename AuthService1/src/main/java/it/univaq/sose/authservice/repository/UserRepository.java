package it.univaq.sose.authservice.repository;

import java.util.List;

import javax.swing.DefaultRowSorter;

import it.univaq.sose.authservice.domain.User;

public class UserRepository {
	
	private static User[] Users = {
			new User("1","marioUsername","1234","mario", "rossi", "via di sotto 17", "Italia" ),
			new User("2","LinoUsername","1234","Lino", "Banfi", "corso umberto 33", "Italia"),
			new User("3","GianniUsername","1234","Gianni", "Celeste", "via po 34", "Italia")};
	
	
	public static synchronized User getUser(String id) throws RepositoryException  {
		for(User user : Users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		throw new RepositoryException("User not found");
		
	}
	
	public static synchronized User getUserByUsername(String username) throws RepositoryException  {
		for(User user : Users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		throw new RepositoryException("User not found");
		
	}
	

}
