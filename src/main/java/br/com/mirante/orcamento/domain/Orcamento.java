package br.com.mirante.orcamento.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orcamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8620639217403305902L;
	@Id
	private Integer id;
	private String descricao;
	private Integer mes;
	private Integer ano;

	@Column(name = "VALOR_TOTAL_INFORMADO")
	private Float valorTotalInformado;

	public Orcamento(String descricao, int mes, int ano, float valorTotalInformado) {
		super();
		this.descricao = descricao;
		this.mes = mes;
		this.ano = ano;
		this.valorTotalInformado = valorTotalInformado;
	}

	protected Orcamento() {

	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getMes() {
		return mes;
	}

	public Integer getAno() {
		return ano;
	}

	public Float getValorTotalInformado() {
		return valorTotalInformado;
	}


}
