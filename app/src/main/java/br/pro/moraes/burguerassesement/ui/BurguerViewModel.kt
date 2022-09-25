package br.pro.moraes.burguerassesement.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pro.moraes.burguerassesement.R
import br.pro.moraes.burguerassesement.data.Produto

class BurguerViewModel: ViewModel() {
    val cardapioLista = mutableListOf<Produto>(
        Produto(1,"Cheese Burguer", 12.90F, R.drawable.ic_temp_frango, "Frango"),
        Produto(2,"American", 19.00F, R.drawable.ic_temp_burguer, "Carne"),
        Produto(3,"Bacon Burguer", 18.00F, R.drawable.ic_temp_burguer, "Carne"),
        Produto(4,"Veg Burguer", 15.00F, R.drawable.ic_temp_frango, "Vegetariano"),
        Produto(5,"Chicken Burguer", 16.00F, R.drawable.ic_temp_frango, "Frango"),
        Produto(6,"Texas", 23.90F,R.drawable.ic_temp_burguer, "Carne"))

    val carrinhoLista = mutableListOf<Produto>()
    val carrinho = MutableLiveData<List<Produto>>()

    val cardapio = MutableLiveData<List<Produto>>()

    init {
        cardapio.value = cardapioLista
        carrinho.value = carrinhoLista
    }


    //Filtros de Cardapio
    fun getFiltrarCarne(): List<Produto>{
        return cardapio.value!!.filter {
            it.tipo == "Carne"
        }
    }

    fun getFiltrarVeg(): List<Produto>{
        return cardapio.value!!.filter {
            it.tipo == "Vegetariano"
        }
    }

    fun getFiltrarFrango(): List<Produto>{
        return cardapio.value!!.filter {
            it.tipo == "Frango"
        }
    }

    fun addInCarrinho(produto: Produto){
        carrinhoLista.add(produto)
        carrinho.value = carrinhoLista
    }



}