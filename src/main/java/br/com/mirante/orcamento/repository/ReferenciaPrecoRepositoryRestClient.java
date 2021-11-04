package br.com.mirante.orcamento.repository;

import br.com.mirante.orcamento.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("restClient")
public class ReferenciaPrecoRepositoryRestClient implements ReferenciaPrecoRepository{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Map<String, Produto> recuperarProdutos(Integer mes, Integer ano, List<String> codigos) {

        return restTemplate.exchange("http://localhost:8083/produto",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Produto>>(){}).getBody();
    }
}

