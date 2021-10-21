package br.com.mirante.orcamento.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.mirante.orcamento.domain.Orcamento;

public class OrcamentoRepositoryEmJava implements OrcamentoRepository {

	static List<Orcamento> orcamentos = new ArrayList<>();

	@Override
	public int obterMaiorId() {
		if (orcamentos.isEmpty()) {
			return 0;
		}
		Orcamento ultimoOrcamento = orcamentos.get(orcamentos.size() - 1);
		return ultimoOrcamento.getId();
	}

	@Override
	public void salvar(Orcamento orcamento) {
		orcamentos.add(orcamento);
	}

	@Override
	public List<Orcamento> listar() {
		return orcamentos;
	}

	@Override
	public Orcamento recuperar(int id) {
		for (Orcamento orcamento : orcamentos) {
			if (orcamento.getId() == id) {
				return orcamento;
			}
		}
		return null;
	}

}
