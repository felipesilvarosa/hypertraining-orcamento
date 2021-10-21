package br.com.mirante.orcamento.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.mirante.orcamento.domain.ItemOrcamento;
import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.services.CadastrarOrcamentoServico;

public class CadastrarOrcamentoUI implements Funcionalidade {

	private CadastrarOrcamentoServico servico = new CadastrarOrcamentoServico();

	Scanner scanner = new Scanner(System.in);

	public void executar() {

		System.out.println("Inicio de cadastro do orçamento");

		System.out.println("Digite a descrição do orçamento");
		String descricaoOrcamento = scanner.nextLine();

		System.out.println("Digite o mês");
		int mes = scanner.nextInt();

		System.out.println("Digite o ano");
		int ano = scanner.nextInt();

		System.out.println("Valor total do orçamento");

		float valorTotal = scanner.nextFloat();
		scanner.nextLine();

		List<String> itens = new ArrayList<>();

		System.out.println("Informe um item do orçamento");
		String item = scanner.nextLine();
		itens.add(item);

		System.out.println("Deseja incluir um novo item? [S] / [N]");
		String novoItem = scanner.nextLine();

		while (novoItem.equalsIgnoreCase("s")) {
			System.out.println("Informe um iten do orçamento");
			item = scanner.nextLine();
			itens.add(item);
			System.out.println("Deseja incluir um novo item? [S] / [N]");
			novoItem = scanner.nextLine();
		}

		List<ItemOrcamento> itensOrcamento = itens.stream().map(this::converter).toList();

		Orcamento orcamento = new Orcamento(descricaoOrcamento, mes, ano, valorTotal, itensOrcamento);

		servico.cadastrar(orcamento);

		new MenuPrincipal().exibir();

	}

	private ItemOrcamento converter(String item) {
		String[] atributos = item.split(";");
		String origem = atributos[0];
		String codigo = atributos[1];
		String descricao = atributos[2];
		float valorUnitario = Float.parseFloat(atributos[3]);
		String unidade = atributos[4];
		float quantidade = Float.parseFloat(atributos[5]);
		float valorTotalInformado = Float.parseFloat(atributos[6]);

		return new ItemOrcamento(origem, codigo, descricao, valorUnitario, unidade, quantidade, valorTotalInformado);

	}
}
