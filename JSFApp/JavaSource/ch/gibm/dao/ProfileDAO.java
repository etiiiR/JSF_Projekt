package ch.gibm.dao;

import ch.gibm.entity.Profile;

public class ProfileDAO extends GenericDAO<Profile> {

	private static final long serialVersionUID = 1L;

	public ProfileDAO() {
		super(Profile.class);
	}

}
