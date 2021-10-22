package br.com.mirante.orcamento.view;

import java.util.stream.Stream;

public class MenuDetalharOrcamentoUI extends Menu {

	protected void imprimirMenu() {
		System.out.println("Digite o n�mero correspondente � op��o desejada");
		Stream.of(OpcoesMenuDetalharOrcamento.values()).forEach(OpcoesMenuDetalharOrcamento::exibir);
	}

	protected void processarOpcaoSelecionadaValida(String opcaoSelecionada) {
		System.out.println("A op��o selecionada foi " + opcaoSelecionada);
		OpcoesMenuDetalharOrcamento.get(opcaoSelecionada).executar();

	}

	protected boolean existe(String opcaoSelecinada) {
		return OpcoesMenuDetalharOrcamento.existe(opcaoSelecinada);
	}
}
