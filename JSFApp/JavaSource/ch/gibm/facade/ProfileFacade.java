package ch.gibm.facade;

import ch.gibm.dao.EntityManagerHelper;
import ch.gibm.dao.ProfileDAO;
import ch.gibm.entity.Profile;

public class ProfileFacade {
	private ProfileDAO profileDAO = new ProfileDAO();
	
	
	public void createProfile(Profile profile) {
		EntityManagerHelper.beginTransaction();
		profileDAO.save(profile);
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public void updateProfile(Profile profile) {
		EntityManagerHelper.beginTransaction();
		Profile persistedProfile = profileDAO.find(profile.getId());
		persistedProfile.setFachteam(profile.getFachteam());
		persistedProfile.setInfos(profile.getInfos());
		persistedProfile.setUser(profile.getUser());
		EntityManagerHelper.commitAndCloseTransaction();
	}
	
	public Profile findProfile(int id) {
		EntityManagerHelper.beginTransaction();
		Profile profile = profileDAO.find(id);
		EntityManagerHelper.commitAndCloseTransaction();
		return profile;
	}
	
	




	
	


	

	
	


}


