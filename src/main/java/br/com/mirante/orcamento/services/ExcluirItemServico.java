package br.com.mirante.orcamento.services;

import br.com.mirante.orcamento.repository.ItemRepository;
import br.com.mirante.orcamento.repository.ItemRepositoryJdbc;

public class ExcluirItemServico {

	private ItemRepository repositorio = new ItemRepositoryJdbc();

	public void excluirItem(Integer idItem) {

		repositorio.excluir(idItem);
	}
}
