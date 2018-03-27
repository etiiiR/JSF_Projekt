package ch.gibm.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.dao.LanguageDAO;
import ch.gibm.dao.PersonDAO;
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

	public void updateUser(User user) {
		EntityManagerHelper.beginTransaction();
		User persistedUser = userDAO.find(user.getId());
		persistedUser.setUsername(user.getUsername());
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public void deletePerson(User user){
		EntityManagerHelper.beginTransaction();
		User persistedUserWithIdOnly = userDAO.findReferenceOnly(user.getId());
		userDAO.delete(persistedUserWithIdOnly);
		EntityManagerHelper.commitAndCloseTransaction();
		
	}

	public User findPerson(int id) {
		EntityManagerHelper.beginTransaction();
		User user = userDAO.find(id);
		EntityManagerHelper.commitAndCloseTransaction();
		return user;
	}

	public User getUserByName(String name) {
		EntityManagerHelper.beginTransaction();
		Query q1 = EntityManagerHelper.getEntityManager().createQuery("SELECT username FROM Users c");
		List results = q1.getResultList();
		EntityManagerHelper.commitAndCloseTransaction();
		return (User) results;
	}
	


}


