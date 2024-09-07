package org.javaexercises.produtoservice.controller;

import lombok.RequiredArgsConstructor;
import org.javaexercises.produtoservice.model.Produto;
import org.javaexercises.produtoservice.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public Flux<Produto> getAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Produto> getById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @PostMapping
    public Mono<Produto> save(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping
    public Mono<Produto> update(@PathVariable Long id,@RequestBody Produto produto) {
        return produtoService.findById(id)
                .flatMap(existingProduto -> {
                   existingProduto.setNome(produto.getNome());
                   existingProduto.setPreco(produto.getPreco());
                   return produtoService.save(existingProduto);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return produtoService.deleteById(id);
    }
}
