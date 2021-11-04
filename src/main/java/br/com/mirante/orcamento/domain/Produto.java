package br.com.mirante.orcamento.domain;


import java.io.Serializable;

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
