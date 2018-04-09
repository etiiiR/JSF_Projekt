package ch.gibm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "user_roles")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Version
    private Long version;
	
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_name")
	@Id
	private User user;
	
	@Id
	@Column(name = "role_name")
	private String role_name;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
}