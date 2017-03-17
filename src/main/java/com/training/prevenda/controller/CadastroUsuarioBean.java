package com.training.prevenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.prevenda.model.Grupo;
import com.training.prevenda.model.Usuario;
import com.training.prevenda.repository.Grupos;
import com.training.prevenda.repository.Usuarios;
import com.training.prevenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario; 

	private List<Grupo> grupo;
	private Grupo p;

	@Inject
	private Usuarios usuarios;
	@Inject
	private Grupos grupos;

	public CadastroUsuarioBean() {
		this.usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void limpar() {
		usuario = new Usuario();
	}

	public void inicializar() {
		grupo = grupos.listaGrupos();

	}

	public void salvar() {
		this.usuario = usuarios.guardar(usuario);
		
		if(usuario == null)	
		limpar();
		
		FacesUtil.EddInfoMessages("Usuario adicionado com sucesso");
	}

	public void adicionarAogrupo() {
		usuario.getGrupos().add(p);
}

	public List<Grupo> getGrupo() {
		return grupo;
	}

	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}

	public Grupo getP() {
		return p;
	}

	public void setP(Grupo p) {
		this.p = p;
	}

}
