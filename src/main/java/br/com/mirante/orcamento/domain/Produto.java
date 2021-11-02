package br.com.mirante.orcamento.domain;

public class Produto {

    private String origem;
    private String codigo;
    private String descricao;
    private String unidadeMedida;
    private Float valor;

    public Produto(String origem, String codigo, String descricao, String unidadeMedida, Float valor) {
        this.origem = origem;
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.valor = valor;
    }

    public String getOrigem() {
        return origem;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public Float getValor() {
        return valor;
    }
}
