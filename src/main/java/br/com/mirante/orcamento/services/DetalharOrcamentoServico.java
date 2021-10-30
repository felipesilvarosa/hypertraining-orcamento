package br.com.mirante.orcamento.services;

import br.com.mirante.orcamento.domain.ItemOrcamento;
import br.com.mirante.orcamento.repository.ItemOrcamentoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.repository.OrcamentoRepository;

import java.util.List;

@Service
public class DetalharOrcamentoServico {
	
	@Autowired
	private OrcamentoRepository repositorio;

	@Autowired
	private ItemOrcamentoRepositoryJpa itensRepositorio;

	public Orcamento recuperar(int id) {
		return repositorio.recuperar(id);
	}

    public List<ItemOrcamento> recuperarItens(Integer id) {
		return itensRepositorio.listarPorIdOrcamento(id);
    }
}
