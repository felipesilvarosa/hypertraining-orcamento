package br.com.mirante.orcamento.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

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

	@OneToMany(mappedBy = "orcamento")
	private List<ItemOrcamento> itensOrcamento;

	public Orcamento(String descricao, int mes, int ano, float valorTotalInformado,
			List<ItemOrcamento> itensOrcamento) {
		super();
		this.descricao = descricao;
		this.mes = mes;
		this.ano = ano;
		this.valorTotalInformado = valorTotalInformado;
		this.itensOrcamento = itensOrcamento;
	}

	protected Orcamento() {

	}

	public List<ItemOrcamento> detalharInconsistencias() {

		ArrayList<ItemOrcamento> itensComInconsistencia = new ArrayList<ItemOrcamento>();

		for (ItemOrcamento itemOrcamento : itensOrcamento) {
			if (itemOrcamento.possuiInconsistencia()) {
				itensComInconsistencia.add(itemOrcamento);
			}
		}
		return itensComInconsistencia;
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

	public List<ItemOrcamento> getItensOrcamento() {
		return itensOrcamento;
	}

}
