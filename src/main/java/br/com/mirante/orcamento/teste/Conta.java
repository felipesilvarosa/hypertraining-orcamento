package br.com.mirante.orcamento.teste;

import java.time.LocalDateTime;

public abstract class Conta {
	protected float saldo;
	private String numero;
	private String agencia;
	private Cliente cliente;
	private LocalDateTime dataAbertura;

	public Conta(String agencia, String numero, Cliente cliente) {
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
		this.dataAbertura = LocalDateTime.now();
	}

	public void depositar(float valor) {
		this.saldo += valor;
	}

	abstract boolean temSaldoSuficiente(float valor);

	public boolean sacar(float valor) {
		if (temSaldoSuficiente(valor)) {
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}
	}

	public float getSaldo() {
		return saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

}
