package com.training.prevenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.training.prevenda.model.Categoria;
import com.training.prevenda.repository.Categorias;
import com.training.prevenda.util.jpa.CDIServiceLocator;

@FacesConverter(forClass = Categoria.class)
public class ConversorCategoria implements Converter {
	//@Inject
	private Categorias categorias;

	public ConversorCategoria(){
		categorias = CDIServiceLocator.getBean(Categorias.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria categoriaRetornada = null;
		if (value != null) {
			Long id = new Long(value);
			categoriaRetornada = categorias.porId(id);

		}

		return categoriaRetornada;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Categoria) value).getId().toString();
		}
		return "";
	}

}
