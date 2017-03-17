package com.training.prevenda.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.training.prevenda.model.Usuario;
import com.training.prevenda.repository.filter.UsuarioFilter;
import com.training.prevenda.util.jpa.Transactional;

public class Usuarios implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	@Transactional
	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);

	}

	public List<Usuario> usuarioFiltrados(UsuarioFilter filter) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = builder.createQuery(Usuario.class);
		Root<Usuario> usuarioRoot = criteriaQuery.from(Usuario.class);
		List<Predicate> predicates = new ArrayList<>();

		if (StringUtils.isNotBlank(filter.getNome())) {
			predicates.add(
					builder.like(builder.lower(usuarioRoot.get("nome")), "%" + filter.getNome().toLowerCase() + "%"));

		}

		criteriaQuery.select(usuarioRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(usuarioRoot.get("nome")));
		TypedQuery<Usuario> query = manager.createQuery(criteriaQuery);
		return query.getResultList();

	}

	public Usuario porId(Long id) {
		return manager.find(Usuario.class, id);
	}

}
