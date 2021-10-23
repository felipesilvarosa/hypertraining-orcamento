package br.com.mirante.orcamento.repository;

import java.util.List;

import br.com.mirante.orcamento.domain.Orcamento;
import jakarta.persistence.EntityManager;

public class OrcamentoRepositoryJpa implements OrcamentoRepository {

	private EntityManager entityManager = JpaUtils.getEntityManager();

	@Override
	public int obterMaiorId() {

		return (Integer) entityManager.createQuery("select max(o.id) from Orcamento o").getSingleResult();
	}

	@Override
	public void salvar(Orcamento orcamento) {
		entityManager.getTransaction().begin();
		entityManager.persist(orcamento);
		entityManager.getTransaction().commit();

	}

	@Override
	public List<Orcamento> listar() {
		return entityManager.createQuery("from Orcamento", Orcamento.class).getResultList();

	}

	@Override
	public Orcamento recuperar(int id) {
		return entityManager.find(Orcamento.class, id);
	}

}
