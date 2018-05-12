package br.com.nutricao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class TurnoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Integer turno = (Integer)value;
		switch (turno) {
			case 1:
				return "Café";
			case 2:
				return "Almoço";
			case 3:
				return "Janta";
			default:
				return null;
		}
	}

}
