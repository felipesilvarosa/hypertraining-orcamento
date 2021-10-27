package br.com.mirante.orcamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mirante.orcamento.repository.ItemRepository;
import br.com.mirante.orcamento.repository.OrcamentoRepository;

@Service
public class ExcluirOrcamentoServico {

	@Autowired
	private OrcamentoRepository repositorio;
	
	@Autowired
	private ItemRepository itemRepositorio;
	
	@Transactional
	public void excluir(Integer id) {
		itemRepositorio.excluirItens(id);
		repositorio.excluir(id);		
	}

}
