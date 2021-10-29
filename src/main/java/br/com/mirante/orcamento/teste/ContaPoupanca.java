package br.com.mirante.orcamento.teste;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String agencia, String numero, Cliente cliente) {
		super(agencia, numero, cliente);
	}

	@Override
	boolean temSaldoSuficiente(float valor) {
		return this.saldo >= valor;
	}

}
