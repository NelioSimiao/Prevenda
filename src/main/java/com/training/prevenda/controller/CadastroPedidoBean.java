package com.training.prevenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.training.prevenda.model.EnderecoEntrega;
import com.training.prevenda.model.Pedido;
import com.training.prevenda.service.NegocioException;

@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Pedido pedido;

	private List<Integer> itens;

	public CadastroPedidoBean() {
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
		itens = new ArrayList<>();
		itens.add(1);
	}

	public void salvar() {
		throw new NegocioException("Pedido não pode ser salvo porque ainda não foi criado.");
	}

	public List<Integer> getItens() {
		return itens;
	}

	public Pedido getPedido() {
		return pedido;
	}

}
