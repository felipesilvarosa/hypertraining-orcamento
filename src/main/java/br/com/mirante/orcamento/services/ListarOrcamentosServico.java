package br.com.mirante.orcamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.repository.OrcamentoRepository;

@Service
public class ListarOrcamentosServico {

	@Autowired
	private OrcamentoRepository repositorio;

	public List<Orcamento> listarOrcamentos() {

		return repositorio.listar();
	}

}
