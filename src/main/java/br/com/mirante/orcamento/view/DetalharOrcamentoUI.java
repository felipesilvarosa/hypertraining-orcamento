package br.com.mirante.orcamento.view;

import java.util.Scanner;

import br.com.mirante.orcamento.domain.ItemOrcamento;
import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.services.DetalharOrcamentoServico;

public class DetalharOrcamentoUI implements Funcionalidade {

	private DetalharOrcamentoServico servico = new DetalharOrcamentoServico();
	private Scanner scanner = new Scanner(System.in);

	public void executar() {

		System.out.println("Digite o código do orçamento: ");
		int id = scanner.nextInt();
		Orcamento orcamentoRecuperado = servico.recuperar(id);
		if (orcamentoRecuperado == null) {
			System.out.println("Não há um orçamento com o código: " + id);
		} else {
			UIUtils.imprimirOrcamento(orcamentoRecuperado);
			System.out.println("Itens: ");
			for (ItemOrcamento item : orcamentoRecuperado.getItensOrcamento()) {
				UIUtils.exibirItemOrcamento(item);
			}
		}

		new MenuPrincipal().exibir();
	}

}
