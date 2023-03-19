package com.apisitecredimoveis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apisitecredimoveis.model.Produto;
import com.apisitecredimoveis.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/all")
	public List<Produto> obterTodos(){
		return repository.findAll();
	}
	
	@GetMapping("/porCodigo")
	public List<Produto> pesquisarCodigo(
			@RequestParam (value = "codigo", required = false, defaultValue = "") Long codigo){
		return repository.findByCodigo(codigo);
	}
	
	@GetMapping("/porDescricao")
	public List<Produto> pesquisarDescricao(
			@RequestParam (value = "descricao", required = false, defaultValue = "") String descricao){
		return repository.findByDescricao("%" + descricao + "%");
	}
}
