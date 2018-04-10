package ch.gibm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.sun.faces.context.flash.ELFlash;

import ch.gibm.entity.Klasse;
import ch.gibm.entity.Person;
import ch.gibm.facade.KlasseFacade;

@ViewScoped
@ManagedBean
public class KlasseBean extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String SELECTED_KLASSE = "selectedKlasse";

	private Person person;
	private Klasse klasse;
	private Klasse klasseWithPersons;
	private Klasse klasseWithPersonsForDetail;
	@ManagedProperty(value="#{personBean}")
	private PersonBean personBean;

	private List<Klasse> klassen;
	private KlasseFacade klassenFacade;


	public void createKlasse() {
		try {
			getKlasseFacade().createKlasse(klasse);
			closeDialog();
			displayInfoMessageToUser("Created with success");
			loadKlassen();
			resetKlasse();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while saving. Try again later");
			e.printStackTrace();
		}
	}

	public void updateKlasse() {
		try {
			getKlasseFacade().updateKlasse(klasse);
			closeDialog();
			displayInfoMessageToUser("Updated with success");
			loadKlassen();
			resetKlasse();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while updating. Try again later");
			e.printStackTrace();
		}
	}

	public void deleteKlasse() {
		try {
			getKlasseFacade().deleteKlasse(klasse);
			closeDialog();
			displayInfoMessageToUser("Deleted with success");
			loadKlassen();
			resetKlasse();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while removing. Try again later");
			e.printStackTrace();
		}
	}

	public void addPersonToKlasse() {
		try {
			getKlasseFacade().addPersonToKlasse(person.getId(), klasseWithPersons.getId());
			closeDialog();
			displayInfoMessageToUser("Added with success");
			reloadKlasseWithPersons();
			resetPerson();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while saving. Try again later");
			e.printStackTrace();
		}
	}
	

	public void removePersonFromKlasse() {
		try {
			getKlasseFacade().removePersonFromKlasse(person.getId(), klasseWithPersons.getId());
			closeDialog();
			displayInfoMessageToUser("Removed with success");
			reloadKlasseWithPersons();
			resetPerson();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while removing. Try again later");
			e.printStackTrace();
		}
	}


	public Klasse getKlasseWithPersons() {
		if (klasseWithPersons == null) {
			klasse = (Klasse) ELFlash.getFlash().get(SELECTED_KLASSE);
			klasseWithPersons = getKlasseFacade().findKlasseWithAllPersons(klasse.getId());
		}

		return klasseWithPersons;
	}
	
	public void setKlassenWithPersonsForDetail(Klasse klasse) {
		klasseWithPersonsForDetail = getKlasseFacade().findKlasseWithAllPersons(klasse.getId());
	}
	


	public Klasse getKlasseWithPersonsForDetail() {
		if (klasseWithPersonsForDetail == null) {
			klasseWithPersonsForDetail = new Klasse();
			klasseWithPersonsForDetail.setPersons(new ArrayList<Person>());
		}
		return klasseWithPersonsForDetail;
	}
	

	public void resetKlasseWithPersonsForDetail() {
		klasseWithPersonsForDetail = new Klasse();
	}
	

	public String editKlassePersons() {
		ELFlash.getFlash().put(SELECTED_KLASSE, klasse);
		return "/pages/public/klasse/klassePersons/klassePersons.xhtml";
	}


	public KlasseFacade getKlasseFacade() {
		if (klassenFacade == null) {
			klassenFacade = new KlasseFacade();
		}

		return klassenFacade;
	}

	public Klasse getKlasse() {
		if (klasse == null) {
			klasse = new Klasse();
		}

		return klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}
	
	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}
	
	public List<Klasse> getAllKlassen() {
		if (klassen == null) {
			loadKlassen();
		}

		return klassen;
	}
	
	public List<Person> getRemainingPersons(String name) {
		//get all languages as copy
		List<Person> res = new ArrayList<Person>(this.personBean.getAllPersons());
		//remove already added languages
		res.removeAll(klasseWithPersons.getPersons());
		//remove when name not occurs
		res.removeIf(l -> l.getName().toLowerCase().contains(name.toLowerCase()) == false);
		return res;
	}
	
	private void loadKlassen() {
		klassen = getKlasseFacade().listAll();
	}

	public void resetKlasse() {
		klasse = new Klasse();
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

	public void resetPerson() {
		person = new Person();
	}
	
	private void reloadKlasseWithPersons() {
		klasseWithPersons = getKlasseFacade().findKlasseWithAllPersons(klasse.getId());
	}
}