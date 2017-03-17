package com.training.prevenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.prevenda.model.Usuario;
import com.training.prevenda.repository.Usuarios;
import com.training.prevenda.repository.filter.UsuarioFilter;

@Named
@ViewScoped
public class PesquisaUsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuariosFiltrados;
	private UsuarioFilter filtro;
	
	@Inject
	private Usuarios usuarios;
	
	public PesquisaUsuarioBean(){
		filtro= new UsuarioFilter();
	}
	
	public void pesquisar(){
		usuariosFiltrados= usuarios.usuarioFiltrados(filtro);
	}

	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}

	public void setUsuariosFiltrados(List<Usuario> usuariosFiltrados) {
		this.usuariosFiltrados = usuariosFiltrados;
	}

	public UsuarioFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(UsuarioFilter filtro) {
		this.filtro = filtro;
	}
	

}
