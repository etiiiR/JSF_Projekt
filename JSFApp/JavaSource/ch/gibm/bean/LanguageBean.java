package ch.gibm.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.gibm.entity.Language;
import ch.gibm.facade.LanguageFacade;

@ViewScoped
@ManagedBean(name="languageBean")
public class LanguageBean extends AbstractBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Language language;
	private List<Language> languages;
	private LanguageFacade languageFacade;

	public LanguageFacade getLanguageFacade() {
		if (languageFacade == null) {
			languageFacade = new LanguageFacade();
		}

		return languageFacade;
	}

	public Language getLanguage() {
		if (language == null) {
			language = new Language();
		}

		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public void createLanguage() {
		try {
			getLanguageFacade().createLanguage(language);
			closeDialog();
			displayInfoMessageToUser("Created with success");
			loadLanguages();
			resetLanguage();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while saving. Try again later");
			e.printStackTrace();
		}
	}
	
	public void updateLanguage() {
		try {
			getLanguageFacade().updateLanguage(language);
			closeDialog();
			displayInfoMessageToUser("Updated with success");
			loadLanguages();
			resetLanguage();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while updating. Try again later");
			e.printStackTrace();
		}
	}
	
	public void deleteLanguage() {
		try {
			getLanguageFacade().deleteLanguage(language);
			closeDialog();
			displayInfoMessageToUser("Deleted with success");
			loadLanguages();
			resetLanguage();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("A problem occurred while removing. Try again later");
			e.printStackTrace();
		}
	}

	public List<Language> getAllLanguages() {
		if (languages == null) {
			loadLanguages();
		}

		return languages;
	}

	private void loadLanguages() {
		languages = getLanguageFacade().listAll();
	}

	public void resetLanguage() {
		language = new Language();
	}
}