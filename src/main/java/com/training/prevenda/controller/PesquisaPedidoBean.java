package com.training.prevenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
public class PesquisaPedidoBean implements Serializable {
private static final long serialVersionUID = 1L;
	
	private List<Integer>produtosFiltrados;
	
	public PesquisaPedidoBean() {
		produtosFiltrados= new ArrayList<>();
		for(Integer i=0;i<10;i++){
			produtosFiltrados.add(i);
			
		}
		
	}

	public void setProdutosFiltrados(List<Integer> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public List<Integer> getProdutosFiltrados() {
		return produtosFiltrados;
	}

}
