package ch.gibm.facade;

import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.dao.RoleDAO;
import ch.gibm.entity.Role;

public class RoleFacade {

private RoleDAO RoleDAO = new RoleDAO();
	
	public void createRole(Role Role) {
		EntityManagerHelper.beginTransaction();
		RoleDAO.save(Role);
		EntityManagerHelper.commitAndCloseTransaction();
	}


}
