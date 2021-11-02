package br.com.mirante.orcamento.repository;

import br.com.mirante.orcamento.domain.Produto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Stream;

public interface ReferenciaPrecoRepository {

    Map<String, Produto> recuperarProdutos(Integer mes, Integer ano, List<String> codigos);

}
