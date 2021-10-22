package br.com.mirante.orcamento.view;

import java.util.Scanner;

public abstract class Menu implements Funcionalidade {
	Scanner scanner = new Scanner(System.in);

	public void executar() {
		imprimirMenu();

		var opcaoSelecionada = scanner.next();

		while (!existe(opcaoSelecionada)) {
			System.out.println("A opção selecionada é invalida, tente novamente");
			imprimirMenu();
			opcaoSelecionada = scanner.next();
		}

		processarOpcaoSelecionadaValida(opcaoSelecionada);

	}

	protected abstract void imprimirMenu();

	protected abstract boolean existe(String opcaoSelecinada);

	protected abstract void processarOpcaoSelecionadaValida(String opcaSElecionada);
}
