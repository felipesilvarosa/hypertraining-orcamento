package br.com.mirante.orcamento.repository;

import java.util.List;

import br.com.mirante.orcamento.domain.Orcamento;

public interface OrcamentoRepository {

	public int obterMaiorId();

	public void salvar(Orcamento orcamento);

	public List<Orcamento> listar();

	public Orcamento recuperar(int id);

}
