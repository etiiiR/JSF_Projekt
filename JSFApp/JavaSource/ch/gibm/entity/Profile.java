package ch.gibm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "user_Profile")
public class Profile implements Serializable {
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
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileid;
	
	private String Infos;
	private String Fachteam;


	public String getInfos() {
		return Infos;
	}

	public void setInfos(String infos) {
		Infos = infos;
	}

	public String getFachteam() {
		return Fachteam;
	}

	public void setFachteam(String fachteam) {
		Fachteam = fachteam;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getProfileid() {
		return profileid;
	}

	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}

	
	


}