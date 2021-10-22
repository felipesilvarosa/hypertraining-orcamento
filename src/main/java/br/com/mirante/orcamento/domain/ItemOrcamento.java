package br.com.mirante.orcamento.domain;

public class ItemOrcamento {
	private Integer id;
	private String origem;
	private String codigoItem;
	private String descricaoItem;
	private float valorUnitario;
	private String unidadeMedida;
	private float quantidade;
	private float valorTotalInformado;

	public ItemOrcamento(Integer id, String origem, String codigoItem, String descricaoItem, float valorUnitario,
			String unidadeMedida, float quantidade, float valorTotalInformado) {

		this(origem, codigoItem, descricaoItem, valorUnitario, unidadeMedida, quantidade, valorTotalInformado);
		this.id = id;
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

}
