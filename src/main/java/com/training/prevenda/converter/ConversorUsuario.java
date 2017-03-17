package com.training.prevenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import com.training.prevenda.model.Usuario;
import com.training.prevenda.repository.Usuarios;
import com.training.prevenda.util.jpa.CDIServiceLocator;

@FacesConverter(forClass = Usuario.class)
public class ConversorUsuario implements Converter {
	// @Inject
	private Usuarios Usuarios;

	public ConversorUsuario() {
		Usuarios = CDIServiceLocator.getBean(Usuarios.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = Usuarios.porId(id);

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Usuario Usuario = (Usuario) value;
			return Usuario.getId() == null ? null : Usuario.getId().toString();
		}
		return "";
	}

}
