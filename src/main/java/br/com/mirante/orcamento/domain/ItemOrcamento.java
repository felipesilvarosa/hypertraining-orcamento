package br.com.mirante.orcamento.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public void setValorTotalInformado(Float valorTotalInformado) {
		this.valorTotalInformado = valorTotalInformado;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

}
