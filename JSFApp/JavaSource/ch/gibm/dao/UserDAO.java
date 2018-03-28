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
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		return super.findOneResult("SELECT c from User where name = :name", map);
		
	}

	
	

	

	
}
