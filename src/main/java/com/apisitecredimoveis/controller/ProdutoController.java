package com.apisitecredimoveis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Produto> obterTodos(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	@GetMapping("/porCodigo")
	public Page<Produto> pesquisarCodigo(
			@RequestParam (value = "codigo", required = false, defaultValue = "") Long codigo, Pageable pageable){
		return repository.findByCodigo(codigo, pageable);
	}
	
	@GetMapping("/porDescricao")
	public Page<Produto> pesquisarDescricao(
			@RequestParam (value = "descricao", required = false, defaultValue = "") Object descricao, Pageable pageable){
		return repository.findByDescricao("%" + descricao + "%", pageable);
	}
}
