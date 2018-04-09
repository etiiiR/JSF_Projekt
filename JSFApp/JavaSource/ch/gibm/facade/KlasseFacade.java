package ch.gibm.facade;

import java.io.Serializable;
import java.util.List;

import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.dao.KlasseDAO;
import ch.gibm.entity.Klasse;

public class KlasseFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private KlasseDAO klasseDAO = new KlasseDAO();

	public void createKlasse(Klasse klasse) {
		EntityManagerHelper.beginTransaction();
		klasseDAO.save(klasse);
		EntityManagerHelper.commitAndCloseTransaction();
	}

	public void updateKlasse(Klasse klasse) {
		EntityManagerHelper.beginTransaction();
		Klasse persistedKlasse = klasseDAO.find(klasse.getId());
		persistedKlasse.setName(klasse.getName());
		klasseDAO.update(persistedKlasse);
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public void deleteKlasse(Klasse klasse) {
		EntityManagerHelper.beginTransaction();
		Klasse persistedKlasse = klasseDAO.findReferenceOnly(klasse.getId());
		klasseDAO.delete(persistedKlasse);
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
}