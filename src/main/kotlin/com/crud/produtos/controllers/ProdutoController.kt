package com.crud.produtos.controllers

import com.crud.produtos.models.Produto
import com.crud.produtos.repository.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/produtos")
class ProdutoController(val produtoRepository: ProdutoRepository) {

    @GetMapping
    fun listaProdutos(): List<Produto> {
        return produtoRepository.findAll()
    }

    @GetMapping("/{id}")
    fun listaProdutoUnico(@PathVariable("id") id: Long): ResponseEntity<Produto> {
        return produtoRepository.findById(id).map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun cadastraProduto(@RequestBody produto: Produto, result: BindingResult): Produto {
        return produtoRepository.save(produto)
    }

    @DeleteMapping("/{id}")
    fun deletaProduto(@PathVariable("id") id: Long) : ResponseEntity<Void>{
        return produtoRepository.findById(id).map {
            produtoRepository.deleteById(it.id)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping
    fun atualizaProduto(@RequestBody produto: Produto): ResponseEntity<Produto> {
        return produtoRepository.findById(produto.id).map {
            ResponseEntity.ok(produtoRepository.save(produto))
        }.orElse(ResponseEntity.notFound().build())

    }
}
