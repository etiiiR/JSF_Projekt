import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.entity.Role;
import ch.gibm.entity.User;

public class TestUser {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@Test
	public void test() {
		EntityManager entity = EntityManagerHelper.getEntityManager();
		entity.getTransaction().begin();
		User user = new User();
		user.setPassword("Roulet");
		user.setUsername("roulet");
		entity.persist(user);
		entity.getTransaction().commit();
		
		
		EntityManager entity2 = EntityManagerHelper.getEntityManager();
		entity2.getTransaction().begin();
		Role role = new Role();
		role.setRole_name("ADMIN");
		role.setUser(user);
		entity2.persist(role);
		entity2.getTransaction().commit();
		
	}

}
