package com.training.prevenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
public class GrupoUsuarioBean {
	private List<Integer> grupoUsuario;

	public GrupoUsuarioBean() {
		grupoUsuario = new ArrayList<>();
		grupoUsuario.add(1);
		grupoUsuario.add(1);
	}

	public List<Integer> getGrupoUsuario() {
		return grupoUsuario;
	}

	

}
