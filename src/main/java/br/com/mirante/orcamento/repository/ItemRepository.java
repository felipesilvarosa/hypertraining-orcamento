package br.com.mirante.orcamento.repository;

import java.util.List;

import br.com.mirante.orcamento.domain.ItemOrcamento;

public interface ItemRepository {

	void excluir(Integer idItem);

	void salvar(List<ItemOrcamento> itens);

	void excluirItens(Integer idOrcamento);
}
