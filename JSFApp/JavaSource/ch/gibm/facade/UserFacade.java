package ch.gibm.facade;

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
		User user = userDAO.searchUserbyName(name);
		EntityManagerHelper.commitAndCloseTransaction();
		return user;
	}
	
	

	public String getFachteam(String name) {
		EntityManagerHelper.beginTransaction();
		User user = userDAO.searchUserbyName(name);
		EntityManagerHelper.commitAndCloseTransaction();
		return user.getFachteam();
	}
	


	public void updateFachteam(User user) {
		EntityManagerHelper.beginTransaction();
		User persistedUser = userDAO.searchUserbyName(user.getName());
		persistedUser.setFachteam(user.getFachteam());
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public String getUsername(String name) {
		EntityManagerHelper.beginTransaction();
		User user = userDAO.searchUserbyName(name);
		EntityManagerHelper.commitAndCloseTransaction();
		return user.getUsername();
	}
	
	public void updateUsername(User user) {
		EntityManagerHelper.beginTransaction();
		User persistedUser = userDAO.searchUserbyName(user.getName());
		persistedUser.setUsername(user.getUsername());
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public String getInfos(String name) {
		EntityManagerHelper.beginTransaction();
		User user = userDAO.searchUserbyName(name);
		EntityManagerHelper.commitAndCloseTransaction();
		return user.getInfos();
	}

	
	public void updateInfos(User user) {
		EntityManagerHelper.beginTransaction();
		User persistedUser = userDAO.searchUserbyName(user.getName());
		persistedUser.setInfos(user.getInfos());
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	


}


