package br.com.mirante.orcamento.view;

public class Sair implements Funcionalidade {

	/*
	 * private Scanner scanner;
	 * 
	 * public Sair(Scanner scanner) { this.scanner = scanner; }
	 */

	@Override
	public void executar() {
		System.out.println("Adeus");
		// scanner.close();
		System.exit(0);
	}

}
