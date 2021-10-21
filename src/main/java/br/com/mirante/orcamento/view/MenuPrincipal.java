package br.com.mirante.orcamento.view;

import java.util.Scanner;
import java.util.stream.Stream;

public class MenuPrincipal {

	Scanner scanner = new Scanner(System.in);

	public void exibir() {
		imprimirMenu();

		// java 10+ pode usar var
		var opcaoSelecionada = scanner.next();

		while (!Menus.existe(opcaoSelecionada)) {
			System.out.println("A opção selecionada é invalida, tente novamente");
			imprimirMenu();
			opcaoSelecionada = scanner.next();
		}

		processarOpcaoSelecionadaValida(opcaoSelecionada);

	}

	private void imprimirMenu() {
		System.out.println("Digite o número correspondente à opção desejada");
		Stream.of(Menus.values()).forEach(Menus::exibir);
	}

	private void processarOpcaoSelecionadaValida(String opcaoSelecionada) {
		System.out.println("A opção selecionada foi " + opcaoSelecionada);
		Menus.get(opcaoSelecionada).executar();

	}
}
