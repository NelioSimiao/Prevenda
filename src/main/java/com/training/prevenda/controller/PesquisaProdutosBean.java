package com.training.prevenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.prevenda.model.Produto;
import com.training.prevenda.repository.Produtos;
import com.training.prevenda.repository.filter.ProdutoFilter;
import com.training.prevenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Produtos produtos;
	private List<Produto> produtosFiltrado;

	private ProdutoFilter filtro;

	private Produto produtoSelecionado;

	public void excluir() {
		produtos.remover(produtoSelecionado);
		produtosFiltrado.remove(produtoSelecionado);
		FacesUtil.EddInfoMessages("Produto excluido com sucesso");
	}

	public PesquisaProdutosBean() {
		filtro = new ProdutoFilter();
	}

	public void pesquisar() {

		produtosFiltrado = produtos.filtrados(filtro);

	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrado;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

}
