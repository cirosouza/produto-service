package org.javaexercises.produtoservice.service;

import lombok.RequiredArgsConstructor;
import org.javaexercises.produtoservice.model.Produto;
import org.javaexercises.produtoservice.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Flux<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Mono<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Mono<Produto> save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Mono<Void> deleteById(Long id) {
        return produtoRepository.deleteById(id);
    }
}
