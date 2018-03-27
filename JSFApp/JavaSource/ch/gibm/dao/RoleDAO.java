package ch.gibm.dao;

import java.util.HashMap;
import java.util.Map;

import ch.gibm.entity.Person;
import ch.gibm.entity.Role;
import ch.gibm.entity.User;

public class RoleDAO extends GenericDAO<Role> {

	private static final long serialVersionUID = 1L;

	public RoleDAO() {
		super(Role.class);
	}

	public void delete(Role role) {
        	super.delete(role.getId(), Role.class);
	}
	

	

	
}
