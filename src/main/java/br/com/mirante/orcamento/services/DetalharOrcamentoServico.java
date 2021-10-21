package br.com.mirante.orcamento.services;

import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.repository.OrcamentoRepository;
import br.com.mirante.orcamento.repository.OrcamentoRepositoryJdbc;

public class DetalharOrcamentoServico {

	private OrcamentoRepository repositorio = new OrcamentoRepositoryJdbc();

	public Orcamento recuperar(int id) {
		return repositorio.recuperar(id);
	}

}
