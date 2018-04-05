package ch.gibm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.sun.faces.context.flash.ELFlash;

import ch.gibm.entity.Klasse;
import ch.gibm.entity.Language;
import ch.gibm.entity.Person;
import ch.gibm.facade.PersonFacade;

@ViewScoped
@ManagedBean
public class PersonBean extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String SELECTED_PERSON = "selectedPerson";

	private Language language;
	private Klasse klasse;
	private Person person;
	private Person personWithLanguages;
	private Person personWithLanguagesForDetail;
	private Person personWithKlassen;
	@ManagedProperty(value="#{languageBean}")
	private LanguageBean languageBean;
	@ManagedProperty(value="#{klasseBean}")
	private KlasseBean klasseBean;


	private List<Person> persons;
	private PersonFacade personFacade;


	public void createPerson() {
		try {
			getPersonFacade().createPerson(person);
			closeDialog();
			displayInfoMessageToUser("Created with success");
			loadPersons();
			resetPerson();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while saving. Try again later");
			e.printStackTrace();
		}
	}

	public void updatePerson() {
		try {
			getPersonFacade().updatePerson(person);
			closeDialog();
			displayInfoMessageToUser("Updated with success");
			loadPersons();
			resetPerson();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while updating. Try again later");
			e.printStackTrace();
		}
	}

	public void deletePerson() {
		try {
			getPersonFacade().deletePerson(person);
			closeDialog();
			displayInfoMessageToUser("Deleted with success");
			loadPersons();
			resetPerson();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while removing. Try again later");
			e.printStackTrace();
		}
	}

	public void addLanguageToPerson() {
		try {
			getPersonFacade().addLanguageToPerson(language.getId(), personWithLanguages.getId());
			closeDialog();
			displayInfoMessageToUser("Added with success");
			reloadPersonWithLanguages();
			resetLanguage();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while saving. Try again later");
			e.printStackTrace();
		}
	}
	
	public void addKlasseToPerson() {
		try {
			getPersonFacade().addKlasseToPerson(klasse.getId(), personWithKlassen.getId());
			closeDialog();
			displayInfoMessageToUser("Added with success");
			reloadPersonWithKlassen();
			resetKlasse();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while saving. Try again later");
			e.printStackTrace();
		}
	}

	public void removeLanguageFromPerson() {
		try {
			getPersonFacade().removeLanguageFromPerson(language.getId(), personWithLanguages.getId());
			closeDialog();
			displayInfoMessageToUser("Removed with success");
			reloadPersonWithLanguages();
			resetLanguage();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while removing. Try again later");
			e.printStackTrace();
		}
	}
	
	public void removeKlasseFromPerson() {
		try {
			getPersonFacade().removeKlasseFromPerson(klasse.getId(), personWithKlassen.getId());
			closeDialog();
			displayInfoMessageToUser("Removed with success");
			reloadPersonWithKlassen();
			resetKlasse();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while removing. Try again later");
			e.printStackTrace();
		}
	}

	public Person getPersonWithLanguages() {
		if (personWithLanguages == null) {
			person = (Person) ELFlash.getFlash().get(SELECTED_PERSON);
			personWithLanguages = getPersonFacade().findPersonWithAllLanguages(person.getId());
		}

		return personWithLanguages;
	}
	
	public Person getPersonWithKlassen() {
		if (personWithKlassen == null) {
			person = (Person) ELFlash.getFlash().get(SELECTED_PERSON);
			personWithKlassen = getPersonFacade().findPersonWithAllKlassen(person.getId());
		}

		return personWithKlassen;
	}

	public void setPersonWithLanguagesForDetail(Person person) {
		personWithLanguagesForDetail = getPersonFacade().findPersonWithAllLanguages(person.getId());
	}

	public Person getPersonWithLanguagesForDetail() {
		if (personWithLanguagesForDetail == null) {
			personWithLanguagesForDetail = new Person();
			personWithLanguagesForDetail.setLanguages(new ArrayList<Language>());
		}
		return personWithLanguagesForDetail;
	}

	public void resetPersonWithLanguagesForDetail() {
		personWithLanguagesForDetail = new Person();
	}

	public String editPersonLanguages() {
		ELFlash.getFlash().put(SELECTED_PERSON, person);
		return "/pages/public/person/personLanguages/personLanguages.xhtml";
	}

	public PersonFacade getPersonFacade() {
		if (personFacade == null) {
			personFacade = new PersonFacade();
		}

		return personFacade;
	}

	public Person getPerson() {
		if (person == null) {
			person = new Person();
		}

		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void setLanguageBean(LanguageBean languageBean) {
		this.languageBean = languageBean;
	}
	
	public void setKlasseBean(KlasseBean klasseBean) {
		this.klasseBean = klasseBean;
	}

	public List<Person> getAllPersons() {
		if (persons == null) {
			loadPersons();
		}

		return persons;
	}
	
	public List<Language> getRemainingLanguages(String name) {
		//get all languages as copy
		List<Language> res = new ArrayList<Language>(this.languageBean.getAllLanguages());
		//remove already added languages
		res.removeAll(personWithLanguages.getLanguages());
		//remove when name not occurs
		res.removeIf(l -> l.getName().toLowerCase().contains(name.toLowerCase()) == false);
		return res;
	}
	
	public List<Klasse> getRemainingKlassen(String name) {
		//get all languages as copy
		List<Klasse> res = new ArrayList<Klasse>(this.klasseBean.getAllKlassen());
		//remove already added languages
		res.removeAll(personWithKlassen.getKlassen());
		//remove when name not occurs
		res.removeIf(l -> l.getName().toLowerCase().contains(name.toLowerCase()) == false);
		return res;
	}

	private void loadPersons() {
		persons = getPersonFacade().listAll();
	}

	public void resetPerson() {
		person = new Person();
	}

	public Language getLanguage() {
		if (language == null) {
			language = new Language();
		}

		return language;
	}

	public Klasse getKlasse() {
		if (klasse == null) {
			klasse = new Klasse();
		}

		return klasse;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}

	public void resetLanguage() {
		language = new Language();
	}
	
	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}

	public void resetKlasse() {
		klasse = new Klasse();
	}
	private void reloadPersonWithLanguages() {
		personWithLanguages = getPersonFacade().findPersonWithAllLanguages(person.getId());
	}
	private void reloadPersonWithKlassen() {
		personWithKlassen = getPersonFacade().findPersonWithAllLanguages(person.getId());
	}
}