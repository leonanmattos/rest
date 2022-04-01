package br.com.leonan.system;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Dependent
public class EntityManagerProducer {
	
	@PersistenceContext
	EntityManager em;

	@Produces
	public EntityManager produceEntityManager() {
		return em;
	}
}
