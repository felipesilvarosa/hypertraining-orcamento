package br.com.mirante.orcamento.view;

import java.util.List;

import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.services.ListarOrcamentosServico;

public class ListarOrcamentoUI implements Funcionalidade {

	private ListarOrcamentosServico servico = new ListarOrcamentosServico();

	public void executar() {
		List<Orcamento> orcamentos = servico.listarOrcamentos();
		for (Orcamento orcamento : orcamentos) {
			UIUtils.imprimirOrcamento(orcamento);
		}
		new MenuPrincipal().exibir();
	}

}
