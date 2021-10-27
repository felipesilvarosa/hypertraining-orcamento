package br.com.mirante.orcamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.repository.OrcamentoRepository;

@Service
public class DetalharOrcamentoServico {
	
	@Autowired
	private OrcamentoRepository repositorio;

	public Orcamento recuperar(int id) {
		return repositorio.recuperar(id);
	}

}
