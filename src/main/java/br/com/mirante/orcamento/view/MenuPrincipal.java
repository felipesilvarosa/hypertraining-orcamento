package br.com.mirante.orcamento.view;

import java.util.stream.Stream;

public class MenuPrincipal extends Menu {

	protected void imprimirMenu() {
		System.out.println("Digite o número correspondente à opção desejada");
		Stream.of(OpcoesMenuPrincipal.values()).forEach(OpcoesMenuPrincipal::exibir);
	}

	protected void processarOpcaoSelecionadaValida(String opcaoSelecionada) {
		System.out.println("A opção selecionada foi " + opcaoSelecionada);
		OpcoesMenuPrincipal.get(opcaoSelecionada).executar();

	}

	@Override
	protected boolean existe(String opcaoSelecinada) {
		return OpcoesMenuPrincipal.existe(opcaoSelecinada);
	}

}