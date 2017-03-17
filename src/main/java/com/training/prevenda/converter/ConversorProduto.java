package com.training.prevenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import com.training.prevenda.model.Produto;
import com.training.prevenda.repository.Produtos;
import com.training.prevenda.util.jpa.CDIServiceLocator;

@FacesConverter(forClass = Produto.class)
public class ConversorProduto implements Converter {
	// @Inject
	private Produtos produtos;

	public ConversorProduto() {
		produtos = CDIServiceLocator.getBean(Produtos.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = produtos.porId(id);

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Produto produto = (Produto) value;
			return produto.getId() == null ? null : produto.getId().toString();
		}
		return "";
	}

}
