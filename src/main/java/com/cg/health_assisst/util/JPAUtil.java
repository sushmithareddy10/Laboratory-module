package com.cg.health_assisst.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * creating JPAUtil class to create JPA fields
 *
 */
public class JPAUtil {
	/**
	 * declaring static variable EntityManagerFactory
	 */
	private static EntityManagerFactory emf;
	/**
	 * creating static variable EntityManager
	 */
	private static EntityManager em;
	/**
	 * creating Persistence class inside the static class
	 */
	static {
		emf = Persistence.createEntityManagerFactory("JPA-PU");
	}

	/**
	 * declaring getEntityManager method which returns the EntityManager object
	 * 
	 * @return
	 */
	public static EntityManager getEntityManager() {
		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
		}
		/**
		 * returning the object of EntityManager
		 */
		return em;
	}
}
