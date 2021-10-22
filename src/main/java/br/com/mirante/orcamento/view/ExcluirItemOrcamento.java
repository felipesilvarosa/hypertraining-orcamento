package br.com.mirante.orcamento.view;

import java.util.Scanner;

import br.com.mirante.orcamento.services.ExcluirItemServico;

public class ExcluirItemOrcamento implements Funcionalidade {

	private Scanner scanner = new Scanner(System.in);
	private ExcluirItemServico servico = new ExcluirItemServico();

	@Override
	public void executar() {
		System.out.println("Digite o a id do item que deseja excluir:");
		Integer idItem = scanner.nextInt();
		servico.excluirItem(idItem);

		System.out.println("Comando executado");

		new MenuDetalharOrcamentoUI().executar();
	}

}
