package ch.gibm.dao;

import ch.gibm.entity.Klasse;

public class KlasseDAO extends GenericDAO<Klasse> {

	private static final long serialVersionUID = 1L;

	public KlasseDAO() {
		super(Klasse.class);
	}

	public void delete(Klasse klasse) {
		super.delete(klasse.getId(), Klasse.class);
	}

}