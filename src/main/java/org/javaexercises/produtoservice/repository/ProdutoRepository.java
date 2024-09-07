package org.javaexercises.produtoservice.repository;

import org.javaexercises.produtoservice.model.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> {
}
