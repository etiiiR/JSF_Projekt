package ch.gibm.dao;

import ch.gibm.entity.Language;

public class LanguageDAO extends GenericDAO<Language> {

	private static final long serialVersionUID = 1L;

	public LanguageDAO() {
		super(Language.class);
	}

	public void delete(Language language) {
		super.delete(language.getId(), Language.class);
	}

}