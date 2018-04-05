package ch.gibm.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "Person.findPersonByIdWithLanguages", query = "select p from Person p left join fetch p.languages where p.id = :personId"),
@NamedQuery(name = "Person.findPersonByIdWithKlassen", query = "select p from Person p left join fetch p.klassen where p.id = :personId")
}) 
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FIND_PERSON_BY_ID_WITH_LANGUAGES = "Person.findPersonByIdWithLanguages";
	public static final String FIND_PERSON_BY_ID_WITH_KLASSEN = "Person.findPersonByIdWithKlassen";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToMany
	private List<Language> languages;
	@ManyToMany
	private List<Klasse> klassen;

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

	public List<Language> getLanguages() {
		return languages;
	}
	
	public List<Klasse> getKlassen() {
		return klassen;
	}
	
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	
	public void setKlassen(List<Klasse> klassen) {
		this.klassen = klassen;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person person = (Person) obj;
			return person.getId() == id;
		}

		return false;
	}
}