package br.com.mirante.orcamento.services;

import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.repository.OrcamentoRepository;
import br.com.mirante.orcamento.repository.OrcamentoRepositoryJpa;

public class DetalharOrcamentoServico {

	private OrcamentoRepository repositorio = new OrcamentoRepositoryJpa();

	public Orcamento recuperar(int id) {
		return repositorio.recuperar(id);
	}

}
