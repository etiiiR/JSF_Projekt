package ch.gibm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_name")
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String nachname;
	private String Telefonnummer;
	private String Natelnummer;
	private String Strasse;
	private String PLZ;
	private int Geschlecht;
	private int SpassscalavonJAVA;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getTelefonnummer() {
		return Telefonnummer;
	}
	public void setTelefonnummer(String telefonnummer) {
		Telefonnummer = telefonnummer;
	}
	public String getNatelnummer() {
		return Natelnummer;
	}
	public void setNatelnummer(String natelnummer) {
		Natelnummer = natelnummer;
	}
	public String getStrasse() {
		return Strasse;
	}
	public void setStrasse(String strasse) {
		Strasse = strasse;
	}
	public String getPLZ() {
		return PLZ;
	}
	public void setPLZ(String pLZ) {
		PLZ = pLZ;
	}
	public int getGeschlecht() {
		return Geschlecht;
	}
	public void setGeschlecht(int geschlecht) {
		Geschlecht = geschlecht;
	}
	public int getSpassscalavonJAVA() {
		return SpassscalavonJAVA;
	}
	public void setSpassscalavonJAVA(int spassscalavonJAVA) {
		SpassscalavonJAVA = spassscalavonJAVA;
	}
	
	
	
}