package com.training.prevenda.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManegerProducer {

	private EntityManagerFactory factory;

	public EntityManegerProducer() {
		factory = Persistence.createEntityManagerFactory("pedido");
	}
	@Produces @RequestScoped
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager manager){
		manager.close();
		
	}

}
