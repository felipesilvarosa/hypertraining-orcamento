package br.com.mirante.orcamento.services;

import java.util.List;

import br.com.mirante.orcamento.domain.ItemOrcamento;
import br.com.mirante.orcamento.repository.ItemOrcamentoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.repository.OrcamentoRepository;

@Service
public class ListarOrcamentosServico {

	@Autowired
	private OrcamentoRepository repositorio;

	@Autowired
	private ItemOrcamentoRepositoryJpa itensRepositorio;

	public List<Orcamento> listarOrcamentos() {
		List<Orcamento> orcamentos = repositorio.listar();
		return orcamentos.stream().map(this::atribuirValorTotal).toList();
	}

	private Orcamento atribuirValorTotal(Orcamento orcamento){
		orcamento.setValorTotalCalculado(calcularValorTotal(orcamento));
		return orcamento;
	}

	private Float calcularValorTotal(Orcamento orcamento){
		List<ItemOrcamento> itens = itensRepositorio.listarPorIdOrcamento(orcamento.getId());
		Float valorTotalOrcamento = 0f;
		for(ItemOrcamento itemOrcamento : itens){
			valorTotalOrcamento += itemOrcamento.getValorTotalCalculado();
		}
		return valorTotalOrcamento;
	}
}
