package com.apisitecredimoveis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apisitecredimoveis.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("SELECT p FROM Produto p where p.codigo = :codigo")
	List<Produto> findByCodigo(@Param("codigo") Long codigo);
	
	@Query("SELECT p FROM Produto p where upper(p.descricao) like upper( :descricao)")
	List<Produto> findByDescricao(@Param("descricao") String descricao);

}
