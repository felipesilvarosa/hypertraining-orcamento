package br.com.mirante.orcamento.view;

import java.util.stream.Stream;

public enum Menus {

	CADASTRAR_ORCAMENTO("1", "Cadastrar orçamento", new CadastrarOrcamentoUI()),
	LISTAR_ORCAMENTO("2", "Listar orçamentos", new ListarOrcamentoUI()),
	DETALHAR_ORCAMENTO("3", "Detalhar orçamentos", new DetalharOrcamentoUI()), SAIR("4", "Sair", new Sair());

	private String numero;
	private String descricao;
	private Funcionalidade executor;

	private Menus(String numero, String descricao, Funcionalidade executor) {
		this.numero = numero;
		this.descricao = descricao;
		this.executor = executor;
	}

	public void exibir() {
		System.out.println("[" + numero + "]" + descricao);
	}

	public void executar() {
		executor.executar();
	}

	static Menus get(String numero) {
		return Stream.of(values()).filter(m -> m.numero.equals(numero)).findFirst().orElse(null);
	}

	static boolean existe(String numero) {
		return Stream.of(values()).anyMatch(m -> m.numero.equals(numero));
	}

}
