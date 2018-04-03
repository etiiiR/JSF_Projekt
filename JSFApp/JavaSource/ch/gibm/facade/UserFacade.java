package ch.gibm.facade;

import javax.persistence.TypedQuery;

import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.dao.UserDAO;
import ch.gibm.entity.Person;
import ch.gibm.entity.User;

public class UserFacade {
	private UserDAO userDAO = new UserDAO();
	
	
	public void createUser(User user) {
		EntityManagerHelper.beginTransaction();
		userDAO.save(user);
		EntityManagerHelper.commitAndCloseTransaction();
	}


	public User getUserByName(String name) {
		EntityManagerHelper.beginTransaction();
		User user = userDAO.searchUserbyName(name);
		EntityManagerHelper.commitAndCloseTransaction();
		return user;
	}

	
	


	

	
	


}


