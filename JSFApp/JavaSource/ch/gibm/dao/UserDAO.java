package ch.gibm.dao;

import java.util.HashMap;
import java.util.Map;

import ch.gibm.entity.Person;
import ch.gibm.entity.User;

public class UserDAO extends GenericDAO<User> {

	private static final long serialVersionUID = 1L;

	public UserDAO() {
		super(User.class);
	}

	public void delete(User user) {
        	super.delete(user.getId(), User.class);
	}
	

	

	
}
