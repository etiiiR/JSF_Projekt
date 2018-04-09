package ch.gibm.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Klasse.findKlasseByIdWithPersons", query = "select p from Klasse p left join fetch p.persons where p.id = :klasseId")
public class Klasse implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FIND_KLASSE_BY_ID_WITH_PERSONS = "Klasse.findKlasseByIdWithPersons";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany
	private List<Person> persons;

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

	public List<Person> getPersons() {
		return persons;
	}
	
	
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Klasse) {
			Klasse klasse = (Klasse) obj;
			return klasse.getId() == id;
		}

		return false;
	}
}