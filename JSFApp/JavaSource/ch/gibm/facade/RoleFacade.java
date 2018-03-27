package ch.gibm.facade;

import java.util.List;

import javax.persistence.Query;

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

	public void updateRole(Role Role) {
		EntityManagerHelper.beginTransaction();
		Role persistedRole = RoleDAO.find(Role.getId());
		persistedRole.setRole_name(Role.getRole_name());
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public void deletePerson(Role Role){
		EntityManagerHelper.beginTransaction();
		Role persistedRoleWithIdOnly = RoleDAO.findReferenceOnly(Role.getId());
		RoleDAO.delete(persistedRoleWithIdOnly);
		EntityManagerHelper.commitAndCloseTransaction();
		
	}

	public Role findPerson(int id) {
		EntityManagerHelper.beginTransaction();
		Role Role = RoleDAO.find(id);
		EntityManagerHelper.commitAndCloseTransaction();
		return Role;
	}

	public Role getRoleByName(String name) {
		EntityManagerHelper.beginTransaction();
		Query q1 = EntityManagerHelper.getEntityManager().createQuery("SELECT Rolename FROM Roles c");
		List results = q1.getResultList();
		EntityManagerHelper.commitAndCloseTransaction();
		return (Role) results;
	}
}
