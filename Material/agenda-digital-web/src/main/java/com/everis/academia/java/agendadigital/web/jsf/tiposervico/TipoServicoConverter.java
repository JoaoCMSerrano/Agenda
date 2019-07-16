package com.everis.academia.java.agendadigital.web.jsf.tiposervico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.everis.academia.java.agendadigital.model.TipoServico;

//@FacesConverter(value="tipoServicoConverter", forClass = TipoServico.class)
public class TipoServicoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (value == null || value.trim().isEmpty()) {
			return null;
		}

		Short codigo = Short.parseShort(value);
		return new TipoServico(codigo);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value instanceof TipoServico) {
			TipoServico tipoServico = (TipoServico) value;
			return String.valueOf(tipoServico.getCodigo());
		}

		return (String) value;
	}

}
