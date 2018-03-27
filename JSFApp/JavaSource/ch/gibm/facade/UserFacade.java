package ch.gibm.facade;

import javax.persistence.TypedQuery;

import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.dao.UserDAO;
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
	TypedQuery<User> query = EntityManagerHelper.getEntityManager().createQuery(
			        "SELECT c FROM users c WHERE c.user_name = :name", User.class);
			    return query.setParameter("name", name).getSingleResult();
		
	}

	

	
	


}


