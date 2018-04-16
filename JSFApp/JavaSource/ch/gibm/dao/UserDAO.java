package ch.gibm.dao;

import ch.gibm.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO extends GenericDAO<User> {

	private static final long serialVersionUID = 1L;

	public UserDAO() {
		super(User.class);
	}

	
	
	public User searchUserbyName(String name) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", name);
		return super.findOneResult(User.FIND_USER_BY_NAME, parameters);
		
	}

	
	

	

	
}
