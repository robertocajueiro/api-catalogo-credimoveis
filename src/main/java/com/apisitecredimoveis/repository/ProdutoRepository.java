package com.apisitecredimoveis.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apisitecredimoveis.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("SELECT p FROM Produto p where p.codigo = :codigo")
	Page<Produto> findByCodigo(@Param("codigo") Long codigo, Pageable pageable);
	
	@Query("SELECT p FROM Produto p where upper(p.descricao) like upper( :descricao)")
	Page<Produto> findByDescricao(@Param("descricao") Object descricao, Pageable pageable);
}
