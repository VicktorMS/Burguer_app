package br.pro.moraes.burguerassesement.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pro.moraes.burguerassesement.data.Produto

class BurguerViewModel: ViewModel() {
    val cardapioLista = mutableListOf<Produto>(
        Produto("Cheese Burguer", 12.90, "Carne"),
        Produto("American", 19.00, "Carne"),
        Produto("Bacon Burguer", 18.00, "Carne"),
        Produto("Veg Burguer", 15.00, "Vegetariano"),
        Produto("Chicken Burguer", 16.00, "Frango"),
        Produto("Texas", 23.90, "Carne"))

     val cardapio = MutableLiveData<List<Produto>>()

    init {
        cardapio.value = cardapioLista
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

}