package br.pro.moraes.burguerassesement.data

import java.math.BigDecimal

data class Produto(
    val nome: String = "",
    val preco: Float = 0.0F,
    val img: Int = 0,
    val tipo: String = "",
    val quantidade: Int = 0

)


