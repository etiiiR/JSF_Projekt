package ch.gibm.dao;

import java.util.HashMap;
import java.util.Map;

import ch.gibm.entity.Klasse;

public class KlasseDAO extends GenericDAO<Klasse> {

	private static final long serialVersionUID = 1L;

	public KlasseDAO() {
		super(Klasse.class);
	}
	
	public Klasse findKlasseWithAllPersons(int klasseId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("klasseId", klasseId);

		return super.findOneResult(Klasse.FIND_KLASSE_BY_ID_WITH_PERSONS, parameters);
	}
	
	public void delete(Klasse klasse) {
		super.delete(klasse.getId(), Klasse.class);
	}

}