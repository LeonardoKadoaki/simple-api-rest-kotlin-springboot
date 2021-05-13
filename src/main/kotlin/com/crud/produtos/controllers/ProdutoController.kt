package com.crud.produtos.controllers

import com.crud.produtos.models.Produto
import com.crud.produtos.repository.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/produtos")
class ProdutoController (val produtoRepository: ProdutoRepository){

    @GetMapping
    fun listaProdutos(): List<Produto>{
        return produtoRepository.findAll()
    }

    @GetMapping("/{id}")
    fun listaProdutoUnico(@PathVariable ("id") id: Long) : Optional<Produto> {
        return produtoRepository.findById(id)
    }

    @PostMapping
    fun cadastraProduto(@RequestBody produto: Produto) : Produto{
        return produtoRepository.save(produto)
    }

    @DeleteMapping
    fun deletaProduto(@RequestBody produto: Produto) {
        produtoRepository.deleteById(produto.id)
    }

    @PutMapping
    fun atualizaProduto(@RequestBody produto: Produto) : Produto{
        return produtoRepository.save(produto)
    }
}
