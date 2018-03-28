package ch.gibm.entity;

import java.io.Serializable;

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
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isUser() {
		// TODO Auto-generated method stub
		return false;
	}

	



}
