package br.com.mirante.orcamento.teste;


import java.util.List;

public class Projeto {
    private String name;
    private List<Pacote> packages;

    public Projeto(String name, List<Pacote> packages){
        this.name = name;
        this.packages = packages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pacote> getPackages() {
        return packages;
    }

    public void setPackages(List<Pacote> packages) {
        this.packages = packages;
    }
}
