package br.com.nutricao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class DiaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Integer dia = (Integer)value;
		switch (dia) {
			case 1:
				return "Domingo";
			case 2:
				return "Segunda";
			case 3:
				return "Terça";
			case 4:
				return "Quarta";
			case 5:
				return "Quinta";
			case 6:
				return "Sexta";
			case 7:
				return "Sábado";
			default:
				return null;
		}
	}

}
