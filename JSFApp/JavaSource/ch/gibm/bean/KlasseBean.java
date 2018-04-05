package ch.gibm.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.gibm.entity.Klasse;
import ch.gibm.facade.KlasseFacade;

@ViewScoped
@ManagedBean(name="klasseBean")
public class KlasseBean extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Klasse klasse;
	private List<Klasse> klassen;
	private KlasseFacade klasseFacade;

	public KlasseFacade getKlasseFacade() {
		if (klasseFacade == null) {
			klasseFacade = new KlasseFacade();
		}

		return klasseFacade;
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

	public List<Klasse> getAllKlassen() {
		if (klasse == null) {
			loadKlassen();
		}

		return klassen;
	}

	private void loadKlassen() {
		klassen = getKlasseFacade().listAll();
	}

	public void resetKlasse() {
		klasse = new Klasse();
	}
}