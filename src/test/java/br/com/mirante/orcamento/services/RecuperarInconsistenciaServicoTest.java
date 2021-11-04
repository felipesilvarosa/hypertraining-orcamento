package br.com.mirante.orcamento.services;

import br.com.mirante.orcamento.domain.ItemOrcamento;
import br.com.mirante.orcamento.domain.Orcamento;
import br.com.mirante.orcamento.domain.Produto;
import br.com.mirante.orcamento.repository.ItemOrcamentoRepositoryJpa;
import br.com.mirante.orcamento.repository.OrcamentoRepository;
import br.com.mirante.orcamento.repository.ReferenciaPrecoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RecuperarInconsistenciaServicoTest {

    @MockBean
    private OrcamentoRepository orcamentoRepository;

    @MockBean
    private ItemOrcamentoRepositoryJpa itemRepository;

    @MockBean
    private ReferenciaPrecoRepository referenciaPrecoRepositorio;

    @MockBean
    private RecuperarInconsistenciasServico recuperarInconsistenciasServico;

    private List<ItemOrcamento> itens = new ArrayList<>();
    private List<String> codigos = new ArrayList<>();

    @BeforeAll
    public void setup(){
        when(orcamentoRepository.recuperar(5)).thenReturn(new Orcamento("Teste", 1, 2021, 0));
        when(itemRepository.listarPorIdOrcamento(5)).thenReturn(itens);
        when(referenciaPrecoRepositorio.recuperarProdutos(1,2010,codigos));
    }

    @Test
    public void naoDeveGerarInconsistencia(){
        List<String> inconsistencias = recuperarInconsistenciasServico.recuperarInconsistencias(5);
        Assertions.assertEquals(inconsistencias.size(), 0);
    }

    @Test
    public void deveGerarInconsistenciaItemQuantidadeZero(){
        RecuperarInconsistenciasServico servico = new RecuperarInconsistenciasServico();
        List<String> inconsistencias = new ArrayList<>();
        ItemOrcamento item = new ItemOrcamento(null, null, null, 0, null, 0, 0);
        servico.verificarInconsistenciaQuantidadeZero(inconsistencias, item, 0);
        Assertions.assertEquals(inconsistencias.size(), 1);
    }

    @Test
    public void naoDeveGerarInconsistenciaItemQuantidadeZero(){
        RecuperarInconsistenciasServico servico = new RecuperarInconsistenciasServico();
        List<String> inconsistencias = new ArrayList<>();
        ItemOrcamento item = new ItemOrcamento(null, null, null, 0, null, 0.5f, 0);
        servico.verificarInconsistenciaQuantidadeZero(inconsistencias, item, 0);
        Assertions.assertEquals(inconsistencias.size(), 0);
    }
}

