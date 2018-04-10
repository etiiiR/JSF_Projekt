package ch.gibm.converter;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import ch.gibm.entity.Person;
import ch.gibm.facade.PersonFacade;

@FacesConverter(forClass = ch.gibm.entity.Person.class)
public class PersonConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		PersonFacade PersonFacade = new PersonFacade();
		int langId;

		try {
			langId = Integer.parseInt(arg2);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Type the name of a Person and select it (or use the dropdown)", "Type the name of a Person and select it (or use the dropdown)"));
		}

		return PersonFacade.findPerson(langId);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 == null) {
			return "";
		}
		Person lang = (Person) arg2;
		return String.valueOf(lang.getId());
	}
}
