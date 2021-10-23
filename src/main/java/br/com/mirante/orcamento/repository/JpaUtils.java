package br.com.mirante.orcamento.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtils {

	static EntityManager getEntityManager() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("default");
		EntityManager entityManager = fabrica.createEntityManager();
		return entityManager;
	}
}
