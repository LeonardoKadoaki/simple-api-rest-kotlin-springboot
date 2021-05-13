package com.crud.produtos.models

import com.sun.istack.NotNull
import javax.persistence.*

@Entity
@Table
data class Produto(

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    val id: Long,

    @Column(length = 50, nullable = false)
    val nome: String,

    @Column(nullable = false)
    val quantidade: Int = 0,

    @Column(nullable = false)
    val valor: Float = 0f


)
