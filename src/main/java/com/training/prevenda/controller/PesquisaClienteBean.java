package com.training.prevenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.training.prevenda.model.Cliente;

@Named
@ViewScoped
public class PesquisaClienteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private List<Integer> clientes;

	public PesquisaClienteBean() {
		cliente = new Cliente();
		clientes = new ArrayList<>();
		clientes.add(1);
		clientes.add(1);
	}

	public List<Integer> getClientes() {
		return clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
