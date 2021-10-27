package br.com.mirante.orcamento.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mirante.orcamento.domain.ItemOrcamento;

@Repository
public class ItemRepositoryJpa implements ItemRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void excluir(Integer idItem) {

		var itemRecuperado = entityManager.find(ItemOrcamento.class, idItem);
		if (itemRecuperado != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(itemRecuperado);
			entityManager.getTransaction().commit();
		}

	}

	@Override
	public void salvar(List<ItemOrcamento> itens) {
		itens.forEach(entityManager::persist);
	}

	@Override
	public void excluirItens(Integer idOrcamento) {
		entityManager
		.createQuery("delete from ItemOrcamento i where i.orcamento.id = :idOrcamento")
		.setParameter("idOrcamento", idOrcamento)
		.executeUpdate();
	}
	
}
