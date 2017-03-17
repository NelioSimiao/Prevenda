package com.training.prevenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.training.prevenda.model.Grupo;
import com.training.prevenda.util.jpa.Transactional;

public class Grupos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	public EntityManager manager;

	@Transactional
	public List<Grupo> listaGrupos() {
		return manager.createQuery("from Grupo", Grupo.class).getResultList();

	}

	public Grupo porId(Long id) {
		return manager.find(Grupo.class, id);
	}

}
