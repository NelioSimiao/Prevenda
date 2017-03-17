package com.training.prevenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.training.prevenda.model.Categoria;
import com.training.prevenda.model.Produto;
import com.training.prevenda.repository.Categorias;
import com.training.prevenda.service.cadastroProdutoService;
import com.training.prevenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private Categorias categorias;
	private Produto produto;
	private Categoria categoriaPai;
	private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;
	@Inject
	private cadastroProdutoService cadastroProdutoService;


	public CadastroProdutoBean() {
		limpar();
	}

	public boolean isEditando() {
		if (produto == null) {
			limpar();
		}
		return this.produto.getId() != null;
	}

	public void inicializar() {
		System.out.println("inicializando");
		if (FacesUtil.isNotPostback()) {
			categoriasRaizes = categorias.raizes();
		}

		if (categoriaPai != null) {
			carregarSubcategorias();

		}
	}

	public void carregarSubcategorias() {
		subcategorias = categorias.subcategoriasde(categoriaPai);

	}

	public void limpar() {
		produto = new Produto();
		categoriaPai = null;
		subcategorias = new ArrayList<>();
	}

	public void salvar() {
		this.produto = cadastroProdutoService.salvar(this.produto);
		limpar();
		FacesUtil.EddInfoMessages("Produto salvo com sucesso");

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		if (produto != null) {
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

	
}
