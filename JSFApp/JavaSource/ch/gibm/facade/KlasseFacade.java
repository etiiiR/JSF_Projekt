package ch.gibm.facade;

import java.io.Serializable;
import java.util.List;

import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.dao.KlasseDAO;
import ch.gibm.dao.PersonDAO;
import ch.gibm.entity.Klasse;
import ch.gibm.entity.Person;

public class KlasseFacade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private KlasseDAO klasseDAO = new KlasseDAO();
	private PersonDAO personDAO = new PersonDAO();

	public void createKlasse(Klasse klasse) {
		EntityManagerHelper.beginTransaction();
		klasseDAO.save(klasse);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public void updateKlasse(Klasse klasse) {
		EntityManagerHelper.beginTransaction();
		Klasse persistedKlasse = klasseDAO.find(klasse.getId());
		persistedKlasse.setName(klasse.getName());
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public void deleteKlasse(Klasse klasse){
		EntityManagerHelper.beginTransaction();
		Klasse persistedKlasseWithIdOnly = klasseDAO.findReferenceOnly(klasse.getId());
		klasseDAO.delete(persistedKlasseWithIdOnly);
		EntityManagerHelper.commitAndCloseTransaction();
		
	}

	public Klasse findKlasse(int klasseId) {
		EntityManagerHelper.beginTransaction();
		Klasse klasse = klasseDAO.find(klasseId);
		EntityManagerHelper.commitAndCloseTransaction();
		return klasse;
	}

	public List<Klasse> listAll() {
		EntityManagerHelper.beginTransaction();
		List<Klasse> result = klasseDAO.findAll();
		EntityManagerHelper.commitAndCloseTransaction();
		return result;
	}

	public Klasse findKlasseWithAllPersons(int klasseId) {
		EntityManagerHelper.beginTransaction();
		Klasse klasse = klasseDAO.findKlasseWithAllPersons(klasseId);
		EntityManagerHelper.commitAndCloseTransaction();
		return klasse;
	}
	
	
	public void addPersonToKlasse(int personId, int klasseId) {
		EntityManagerHelper.beginTransaction();
		Person person = personDAO.find(personId);
		Klasse klasse = klasseDAO.find(klasseId);
		klasse.getPersons().add(person);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public void removePersonFromKlasse(int personId, int klasseId) {
		EntityManagerHelper.beginTransaction();
		Person person = personDAO.find(personId);
		Klasse klasse = klasseDAO.find(klasseId);
		klasse.getPersons().remove(person);
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
}