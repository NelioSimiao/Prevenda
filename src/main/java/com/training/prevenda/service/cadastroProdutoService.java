package com.training.prevenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.training.prevenda.model.Produto;
import com.training.prevenda.repository.Produtos;
import com.training.prevenda.util.jpa.Transactional;

public class cadastroProdutoService implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private Produtos produtos;

	@Transactional
	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtos.porSku(produto.getSku());
		if (produtoExistente != null && !produtoExistente.equals(produto)) {
			throw new NegocioException("Ja existe o produto com Sku informado.");
		}
		produto = produtos.guardar(produto);
		return produto;

	}
}
