package ch.gibm.test;
import javax.persistence.EntityManager;

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
		user.setName("User");
		user.setPass("User");
		user.setFachteam("JAVA");
		user.setInfos("Ich bin ein JAVA programmierer");
		user.setUsername("User Kasper");
		entity.persist(user);
		entity.getTransaction().commit();
		
		
		EntityManager entity2 = EntityManagerHelper.getEntityManager();
		entity2.getTransaction().begin();
		Role role = new Role();
		role.setRole_name("USERS");
		role.setUser(user);
		entity2.persist(role);
		entity2.getTransaction().commit();
		
		EntityManager entity3 = EntityManagerHelper.getEntityManager();
		entity2.getTransaction().begin();
		User user2 = new User();
		user2.setName("Admin");
		user2.setPass("Admin");
		user2.setFachteam("SAP");
		user2.setInfos("Ich bin ein SAP programmierer");
		user2.setUsername("Admin CHEFETI");
		entity3.persist(user2);
		entity3.getTransaction().commit();
		
		
		EntityManager entity4 = EntityManagerHelper.getEntityManager();
		entity4.getTransaction().begin();
		Role role2 = new Role();
		role2.setRole_name("ADMIN");
		role2.setUser(user2);
		entity4.persist(role2);
		entity4.getTransaction().commit();
		
		EntityManager entity5 = EntityManagerHelper.getEntityManager();
		entity5.getTransaction().begin();
		User user3 = new User();
		user3.setName("Owner");
		user3.setPass("Owner");
		user3.setFachteam("JS");
		user3.setInfos("Ich bin ein JS programmierer");
		user3.setUsername("Admin KETTI");
		entity5.persist(user3);
		entity5.getTransaction().commit();
		
		
		EntityManager entity6 = EntityManagerHelper.getEntityManager();
		entity6.getTransaction().begin();
		Role role3 = new Role();
		role3.setRole_name("OWNER");
		role3.setUser(user3);
		entity6.persist(role3);
		entity6.getTransaction().commit();
	
		
	}

}
