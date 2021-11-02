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

import static java.util.stream.Collectors.toList;

@Service
public class RecuperarInconsistenciasServico {

    @Autowired
    private ItemOrcamentoRepositoryJpa itensRepositorio;

    @Autowired
    private OrcamentoRepository orcamentoRepositorio;

    @Autowired
    private ReferenciaPrecoRepository referenciaPrecoRepositorio;

    public List<String> recuperarInconsistencias(Integer id){
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
        if(itemOrcamento.getQuantidade() == 0F){
            inconsistencias.add("O item de id " + numeroItem + " possui quantidade iguala zero.");
        }

        if (itemOrcamento.getValorTotalCalculado() != itemOrcamento.getValorTotalInformado()){
            inconsistencias.add(
                    "O valor total do item de id " + numeroItem
                            + " deveria ser R$" + itemOrcamento.getValorTotalCalculado()
                            + " mas foi R$" + itemOrcamento.getValorTotalInformado());
        }

        if(produtos.containsKey(itemOrcamento.getCodigo())){
            Produto produto = produtos.get(itemOrcamento.getCodigo());

            if (!produto.getUnidadeMedida().equals(itemOrcamento.getUnidadeMedida())){
                inconsistencias.add("A unidade do item numero "
                        + numeroItem +
                        "("+ itemOrcamento.getUnidadeMedida() + ")"
                        + " diverge da unidade de referencia que é "
                        + produto.getUnidadeMedida());
            }

            // Verificar o sobrepreço.

        } else {
            inconsistencias.add(
                    "O item " + numeroItem + " não possuiu uma referencia de preço valida"
            );
        }
    }
}
