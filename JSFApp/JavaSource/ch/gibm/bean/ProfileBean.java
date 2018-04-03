package ch.gibm.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.gibm.entity.Profile;
import ch.gibm.facade.ProfileFacade;

@ViewScoped
@ManagedBean(name="profileBean")
public class ProfileBean extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Profile profile;
	private List<Profile> profiles;
	private ProfileFacade profileFacade;

	public ProfileFacade getProfileFacade() {
		if (profileFacade == null) {
			profileFacade = new ProfileFacade();
		}

		return profileFacade;
	}

	public Profile getProfile() {
		if (profile == null) {
			profile = new Profile();
		}

		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	
	
	public void updateProfile() {
		try {
			getProfileFacade().updateProfile(profile);
			closeDialog();
			displayInfoMessageToUser("Updated with success");
			loadProfiles();
			resetProfile();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while updating. Try again later");
			e.printStackTrace();
		}
	}
	
	

	

	private void loadProfiles() {
		profiles = getProfileFacade().listAll();
	}

	public void resetProfile() {
		profile = new Profile();
	}
}