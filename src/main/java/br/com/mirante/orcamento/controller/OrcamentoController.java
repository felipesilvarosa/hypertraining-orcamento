package br.com.mirante.orcamento.controller;

import java.util.List;

import br.com.mirante.orcamento.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.mirante.orcamento.domain.ItemOrcamento;
import br.com.mirante.orcamento.domain.Orcamento;

@RestController
public class OrcamentoController {

	@Autowired
	private ListarOrcamentosServico servico;
	
	@Autowired
	private DetalharOrcamentoServico detalharServico;
	
	@Autowired
	private CadastrarOrcamentoServico cadastrarServico;
	
	@Autowired
	private ExcluirOrcamentoServico excluirServico;

	@Autowired
	private AtualizarOrcamentoServico atualizarServico;


	@GetMapping("/orcamentos")
	public List<Orcamento> listarOrcamentos(){
		return servico.listarOrcamentos();
	}
	
	@GetMapping("/orcamentos/{id}")
	public Orcamento recuperarOrcamento(@PathVariable Integer id) {
		return detalharServico.recuperar(id);
	}
	
	@PostMapping("/orcamentos")
	public Orcamento cadastrarOrcamento(@RequestBody CadastrarOrcamentoRequest requisicao) {
		return cadastrarServico.cadastrar(requisicao.orcamento, requisicao.itens);	
	}

	@DeleteMapping("/orcamentos/{id}")
	public void excluirOrcamento(@PathVariable Integer id) {
		excluirServico.excluir(id);
	}

	@PutMapping("/orcamentos/{id}")
	public void atualizarOrcamento(@PathVariable Integer id, @RequestBody Orcamento orcamento){
		atualizarServico.atualizar(id, orcamento);
	}
}

class CadastrarOrcamentoRequest{
	Orcamento orcamento;
	List<ItemOrcamento> itens;
	
	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	public List<ItemOrcamento> getItens() {
		return itens;
	}
	public void setItens(List<ItemOrcamento> itens) {
		this.itens = itens;
	}
	
	
}