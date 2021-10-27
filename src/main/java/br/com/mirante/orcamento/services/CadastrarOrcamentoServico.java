package br.com.mirante.orcamento.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mirante.orcamento.domain.ItemOrcamento;
import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.repository.ItemRepository;
import br.com.mirante.orcamento.repository.OrcamentoRepository;

@Service
public class CadastrarOrcamentoServico {

	@Autowired
	private OrcamentoRepository repositorio;
	
	@Autowired
	private ItemRepository itensRepositorio;
	
	@Transactional
	public Orcamento cadastrar(Orcamento orcamento, List<ItemOrcamento> itens) {
		int maiorId = repositorio.obterMaiorId();
		orcamento.setId(maiorId + 1);
		repositorio.salvar(orcamento);
		itens.forEach(item -> item.setOrcamento(orcamento));
		itensRepositorio.salvar(itens);
		return orcamento;
	}
}
