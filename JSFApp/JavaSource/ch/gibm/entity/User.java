package ch.gibm.entity;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findUserbyName", query = "select u from User u  where name = :name")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_USER_BY_NAME= "User.findUserbyName";
	
	@Version
    private Long version;
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	@Id
	@Column(name = "user_name")
	private String name;
	
	
	
	public void setInfos(String infos) {
		Infos = infos;
	}
	@Column(name = "user_pass")
	private String pass;
	
	private String Username;
	private String Fachteam;
	private String Infos;
	
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getFachteam() {
		return Fachteam;
	}

	public void setFachteam(String fachteam) {
		Fachteam = fachteam;
	}

	public String getInfos() {
		return Infos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isAdmin() {
		if(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("ADMIN")) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isUser() {
		if(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("USERS")) {
			return true;
		} else {
			
	}
		return false;


	}

	public boolean isOwner() {
		if(FacesContext.getCurrentInstance().getExternalContext().isUserInRole("OWNER")) {
			return true;
		} else {
			
	}
		return false;
	}
	



}
