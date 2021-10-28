package br.com.mirante.orcamento.services;

import br.com.mirante.orcamento.repository.ItemOrcamentoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;

public class ExcluirItemServico {

	@Autowired
	private ItemOrcamentoRepositoryJpa repositorio;

	public void excluirItem(Integer idItem) {
		repositorio.deleteById(idItem);
	}
}
