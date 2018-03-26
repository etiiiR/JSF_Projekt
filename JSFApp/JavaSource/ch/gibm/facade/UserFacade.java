package ch.gibm.facade;

import java.util.List;

import javax.persistence.EntityManager;

import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.dao.LanguageDAO;
import ch.gibm.dao.PersonDAO;
import ch.gibm.dao.UserDAO;
import ch.gibm.entity.Person;
import ch.gibm.entity.User;

public class UserFacade {
	private UserDAO userDAO = new UserDAO();
	
	public User getUserByName(String name) {
			EntityManagerHelper.beginTransaction();
			User user = userDAO.find(User.class, 1);
			EntityManagerHelper.commitAndCloseTransaction();
		return user;
	}

}
