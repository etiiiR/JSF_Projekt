package ch.gibm.bean;

import java.io.Serializable;
import java.security.Principal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ch.gibm.entity.User;
import ch.gibm.facade.UserFacade;



@SessionScoped
@ManagedBean(name = "userBean")
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private User user;
	private UserFacade userFacade;

	public boolean isAdmin() {
		return this.getUser() != null ? user.isAdmin() : false;
	}

	public boolean isDefaultUser() {
		return this.getUser() != null ? user.isUser() : false;
	}
	
	public boolean isOwer() {
		return this.getUser() != null ? user.isOwner() : false;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/public/index?faces-redirect=true";
	}

	public User getUser() {
		if (user == null) {
			Principal principal =

					FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();

			if (principal != null) {
				UserFacade userFacade = new UserFacade();
				user = userFacade.getUserByName(principal.getName());
			}
		}
		return user;
	}
	
	public String getFachteam() {
		return getUserFacade().getUserByName(getUser().getName()).getFachteam();
		
	}
	
	public String getUsername() {
		return getUserFacade().getUserByName(getUser().getName()).getUsername();
		
	}
	
	public String getInfos() {
		return getUserFacade().getUserByName(getUser().getName()).getInfos();
		
	}
	
	
	
	
	
	public void updateFachteam() {
		try {
			getUserFacade().updateFachteam(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateInfos() {
		try {
			getUserFacade().updateInfos(getUser());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUsername() {
		try {
			getUserFacade().updateUsername(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public UserFacade getUserFacade() {
		if (userFacade == null) {
			userFacade = new UserFacade();
		}

		return userFacade;
	}
	
	

}