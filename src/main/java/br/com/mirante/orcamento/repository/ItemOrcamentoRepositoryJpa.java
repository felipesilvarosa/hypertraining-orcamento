package br.com.mirante.orcamento.repository;

import br.com.mirante.orcamento.domain.ItemOrcamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemOrcamentoRepositoryJpa extends JpaRepository<ItemOrcamento, Integer> {

    void deleteById(Integer id);
    
    @Modifying
    @Query("delete from ItemOrcamento i where i.orcamento.id = :idOrcamento")
    void deleteByIdOrcamento(Integer idOrcamento);

    @Query("from ItemOrcamento i where i.orcamento.id = :idOrcamento")
    List<ItemOrcamento> listarPorIdOrcamento(Integer idOrcamento);
}
