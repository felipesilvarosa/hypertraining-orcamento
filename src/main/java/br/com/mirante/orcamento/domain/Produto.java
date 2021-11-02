package br.com.mirante.orcamento.domain;

public class IdentificadorProduto {

    private String origem;
    private String codigo;

    public IdentificadorProduto(String origem, String codigo) {
        super();
        this.origem = origem;
        this.codigo = codigo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getCodigo() {
        return codigo;
    }
}
