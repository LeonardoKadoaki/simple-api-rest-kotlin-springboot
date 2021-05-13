package com.crud.produtos.repository

import com.crud.produtos.models.Produto
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository : JpaRepository<Produto, Long> {


}