package br.com.mirante.orcamento.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ITEM_ORCAMENTO")
public class ItemOrcamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4521914098412108603L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String origem;

	@Column(name = "CODIGO")
	private String codigoItem;

	@Column(name = "DESCRICAO")
	private String descricaoItem;

	@Column(name = "VALOR_UNITARIO")
	private Float valorUnitario;

	@Column(name = "UNIDADE")
	private String unidadeMedida;

	private Float quantidade;

	@Column(name = "VALOR_TOTAL_INFORMADO")
	private Float valorTotalInformado;

	@ManyToOne
	@JoinColumn(name = "ID_ORCAMENTO")
	private Orcamento orcamento;

	public ItemOrcamento(Integer id, String origem, String codigoItem, String descricaoItem, float valorUnitario,
			String unidadeMedida, float quantidade, float valorTotalInformado) {

		this(origem, codigoItem, descricaoItem, valorUnitario, unidadeMedida, quantidade, valorTotalInformado);
		this.id = id;
	}

	protected ItemOrcamento() {

	}

	public ItemOrcamento(String origem, String codigoItem, String descricaoItem, float valorUnitario,
			String unidadeMedida, float quantidade, float valorTotalInformado) {

		this.origem = origem;
		this.codigoItem = codigoItem;
		this.descricaoItem = descricaoItem;
		this.valorUnitario = valorUnitario;
		this.unidadeMedida = unidadeMedida;
		this.quantidade = quantidade;
		this.valorTotalInformado = valorTotalInformado;
	}

	public Integer getId() {
		return id;
	}

	public boolean possuiInconsistencia() {
		return valorUnitario * quantidade != valorTotalInformado;
	}

	public String getOrigem() {
		return origem;
	}

	public String getCodigo() {
		return codigoItem;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public float getValorTotalInformado() {
		return valorTotalInformado;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

}
