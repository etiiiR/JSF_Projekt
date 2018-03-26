package ch.gibm.converter;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import ch.gibm.entity.Language;
import ch.gibm.facade.LanguageFacade;

@FacesConverter(forClass = ch.gibm.entity.Language.class)
public class LanguageConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		LanguageFacade lngFacade = new LanguageFacade();
		int langId;

		try {
			langId = Integer.parseInt(arg2);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Type the name of a language and select it (or use the dropdown)", "Type the name of a language and select it (or use the dropdown)"));
		}

		return lngFacade.findLanguage(langId);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 == null) {
			return "";
		}
		Language lang = (Language) arg2;
		return String.valueOf(lang.getId());
	}
}
