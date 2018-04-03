package ch.gibm.bean;

import java.io.Serializable;
import java.security.Principal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ch.gibm.entity.Person;
import ch.gibm.entity.Profile;
import ch.gibm.entity.User;
import ch.gibm.facade.PersonFacade;
import ch.gibm.facade.ProfileFacade;
import ch.gibm.facade.UserFacade;

@SessionScoped
@ManagedBean(name = "profileBean")
public class ProfileBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Profile profile;
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
	
	public void createProfile() {
		try {
			getProfileFacade().createProfile(profile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}