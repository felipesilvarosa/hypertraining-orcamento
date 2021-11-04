package br.com.mirante.orcamento.services;

import br.com.mirante.orcamento.domain.ItemOrcamento;
import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.domain.Produto;
import br.com.mirante.orcamento.repository.ItemOrcamentoRepositoryJpa;
import br.com.mirante.orcamento.repository.OrcamentoRepository;
import br.com.mirante.orcamento.repository.ReferenciaPrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RecuperarInconsistenciasServico {

    @Autowired
    private ItemOrcamentoRepositoryJpa itensRepositorio;

    @Autowired
    private OrcamentoRepository orcamentoRepositorio;

    @Autowired
    private ReferenciaPrecoRepository referenciaPrecoRepositorio;

    public List<String> recuperarInconsistencias(Integer id) {
        List<String> inconsistencias = new ArrayList<>();
        List<ItemOrcamento> itens = itensRepositorio.listarPorIdOrcamento(id);
        Orcamento orcamento = orcamentoRepositorio.recuperar(id);

        Map<String, Produto> produtos = referenciaPrecoRepositorio.recuperarProdutos(
                orcamento.getMes(),
                orcamento.getAno(),
                itens.stream().map(ItemOrcamento::getCodigo).toList());


        for(int index = 0; index < itens.size(); index++){
            ItemOrcamento itemOrcamento = itens.get(index);
            int numeroItem = index + 1;

            inconsistenciasDoItem(inconsistencias, itemOrcamento, numeroItem, produtos);
        }

        return inconsistencias;
    }

    private void inconsistenciasDoItem(List<String> inconsistencias, ItemOrcamento itemOrcamento, int numeroItem, Map<String, Produto> produtos) {
        verificarInconsistenciaQuantidadeZero(inconsistencias, itemOrcamento, numeroItem);
        veirificarInconsistenciaValorCalculado(inconsistencias, itemOrcamento, numeroItem);
        verificarInconsistenciaPresencaReferenciaPreco(inconsistencias, itemOrcamento, numeroItem, produtos);
    }

    private void verificarInconsistenciaPresencaReferenciaPreco(List<String> inconsistencias, ItemOrcamento itemOrcamento, int numeroItem, Map<String, Produto> produtos) {

        Orcamento orcamento = itemOrcamento.getOrcamento();
        String produtoKey = orcamento.getMes()+""+orcamento.getAno()+""+itemOrcamento.getCodigo();

        if(produtos.containsKey(produtoKey)){

            Produto produto = produtos.get(produtoKey);

            if (!produto.getUnidadeMedida().equals(itemOrcamento.getUnidadeMedida())){
                inconsistencias.add("A unidade do item numero "
                        + numeroItem +
                        "("+ itemOrcamento.getUnidadeMedida() + ")"
                        + " diverge da unidade de referencia que é "
                        + produto.getUnidadeMedida());
            }

            Float valorTotalCalculadoReferencia = produto.getValor() * itemOrcamento.getQuantidade();

            if (itemOrcamento.getValorTotalCalculado() > valorTotalCalculadoReferencia){
                Float valorSobrePreco = itemOrcamento.getValorTotalCalculado() - valorTotalCalculadoReferencia;
                Float percentual = valorSobrePreco / valorTotalCalculadoReferencia * 100 ;
                inconsistencias.add("O item número " + numeroItem + " possui sobrepreço de " + percentual + "%");
            }

        } else {
            inconsistencias.add(
                    "O item " + numeroItem + " não possuiu uma referencia de preço valida"
            );
        }
    }

    private void veirificarInconsistenciaValorCalculado(List<String> inconsistencias, ItemOrcamento itemOrcamento, int numeroItem) {
        if (itemOrcamento.getValorTotalCalculado() != itemOrcamento.getValorTotalInformado()){
            inconsistencias.add(
                    "O valor total do item de id " + numeroItem
                            + " deveria ser R$" + itemOrcamento.getValorTotalCalculado()
                            + " mas foi R$" + itemOrcamento.getValorTotalInformado());
        }
    }

    protected void verificarInconsistenciaQuantidadeZero(List<String> inconsistencias, ItemOrcamento itemOrcamento, int numeroItem) {
        if(itemOrcamento.getQuantidade() == 0F){
            inconsistencias.add("O item de id " + numeroItem + " possui quantidade iguala zero.");
        }
    }
}
