package br.com.mirante.orcamento.services;

import br.com.mirante.orcamento.repository.ItemRepository;
import br.com.mirante.orcamento.repository.ItemRepositoryJpa;

public class ExcluirItemServico {

	private ItemRepository repositorio = new ItemRepositoryJpa();

	public void excluirItem(Integer idItem) {

		repositorio.excluir(idItem);
	}
}
