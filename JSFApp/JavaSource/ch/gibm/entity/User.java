package ch.gibm.entity;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findUserbyName", query = "select u from User u  where name = :name")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_USER_BY_NAME= "User.findUserbyName";
	
	@Id
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_pass")
	private String pass;
		

	

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
	



}
