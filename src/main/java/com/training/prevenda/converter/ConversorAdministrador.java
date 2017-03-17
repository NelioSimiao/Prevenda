package com.training.prevenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import com.training.prevenda.model.Grupo;
import com.training.prevenda.repository.Grupos;
import com.training.prevenda.util.jpa.CDIServiceLocator;

@FacesConverter(forClass=Grupo.class)
public class ConversorAdministrador implements Converter {
	
	private Grupos grupos;
	
	public  ConversorAdministrador(){
		grupos = CDIServiceLocator.getBean(Grupos.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo retorno= null;
		
		if(StringUtils.isNotEmpty(value)){
			Long id= new Long(value);
			
			retorno=grupos.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value!=null){
			Grupo grupo= (Grupo) value;
		return grupo.getId().toString();
		}
		return "";
	}
	
}
