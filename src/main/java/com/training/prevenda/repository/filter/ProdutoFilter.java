package com.training.prevenda.repository.filter;

import java.io.Serializable;

import com.training.prevenda.validation.Sku;

public class ProdutoFilter implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sku;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Sku
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku==null? null:sku.toUpperCase();
	}

}
