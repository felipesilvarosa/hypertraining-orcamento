package br.com.mirante.orcamento.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemOrcamentoTest {

    @Test
    public void deveGerarInconsistenciaSeOCalculoDivergir(){
        ItemOrcamento item = new ItemOrcamento(
                1, "IBGE", "abc", "teste", 5.2f, "un", 3.5f, 18.3f
        );

        Assertions.assertTrue(item.possuiInconsistencia());
    }

    @Test
    public void naoDeveGerarInconsistenciaSeOCalculoDivergir(){
        ItemOrcamento item = new ItemOrcamento(
                1, "IBGE", "abc", "teste", 3.2f, "un", 7.2f, 23.04f
        );

        Assertions.assertFalse(item.possuiInconsistencia());
    }

    @Test
    public void valorCalculadoInferior(){
        ItemOrcamento item = new ItemOrcamento(
                1, "IBGE", "abc", "teste", 5.2f, "un", 3.5f, 18.1f
        );

        Assertions.assertTrue(item.possuiInconsistencia());
    }
}
