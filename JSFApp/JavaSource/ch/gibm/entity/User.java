package ch.gibm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "user_name")
	private String user_name;
	@Column(name = "user_pass")
	private String user_pass;
		

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
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
