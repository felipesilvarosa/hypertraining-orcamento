package br.com.mirante.orcamento.teste;

public class ContaCorrente extends Conta {

	public ContaCorrente(String agencia, String numero, Cliente cliente) {
		super(agencia, numero, cliente);
	}

	private float limite;

	@Override
	boolean temSaldoSuficiente(float valor) {
		return saldo + limite >= valor;
	}

}
