package com.training.prevenda.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.training.prevenda.model.Categoria;
import com.training.prevenda.model.Produto;
import com.training.prevenda.repository.filter.ProdutoFilter;
import com.training.prevenda.service.NegocioException;
import com.training.prevenda.util.jpa.Transactional;

public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public void remover(Produto produto) {
		try {
			produto = porId(produto.getId());
			manager.remove(produto);
			manager.flush();
		} catch (PersistenceException e) {

		throw new NegocioException("O produto não pode ser excluido.");

		}

	}

	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}

	public Produto porSku(String sku) {
		try {
			return manager.createQuery("from Produto where upper(sku)=:sku", Produto.class)
					.setParameter("sku", sku.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;

		}
	}
	@Transactional
	public List<Produto> filtrados(ProdutoFilter filtro) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);
		List<Predicate> predicate = new ArrayList<>();
		Root<Produto> produtoRoot = criteriaQuery.from(Produto.class);

		Fetch<Produto, Categoria> categoriaJoin = produtoRoot.fetch("categoria", JoinType.INNER);
		categoriaJoin.fetch("categoriaPai", JoinType.INNER);

		if (StringUtils.isNotBlank(filtro.getSku())) {
			predicate.add(builder.equal(produtoRoot.get("sku"), filtro.getSku()));
		}
		if (StringUtils.isNotBlank(filtro.getNome())) {
			predicate.add(
					builder.like(builder.lower(produtoRoot.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));

		}
		criteriaQuery.select(produtoRoot);
		criteriaQuery.where(predicate.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(produtoRoot.get("nome")));
		TypedQuery<Produto> query = manager.createQuery(criteriaQuery);

		return query.getResultList();

	}

	public Produto porId(Long id) {
		return manager.find(Produto.class, id);
	}

}
