package br.pro.moraes.burguerassesement.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pro.moraes.burguerassesement.R
import br.pro.moraes.burguerassesement.data.Produto

class BurguerViewModel: ViewModel() {
    val cardapioLista = mutableListOf<Produto>(
        Produto("Cheese Burguer", 12.90F, R.drawable.ic_temp_frango, "Frango"),
        Produto("American", 19.00F, R.drawable.ic_temp_burguer, "Carne"),
        Produto("Bacon Burguer", 18.00F, R.drawable.ic_temp_burguer, "Carne"),
        Produto("Veg Burguer", 15.00F, R.drawable.ic_temp_frango, "Vegetariano"),
        Produto("Chicken Burguer", 16.00F, R.drawable.ic_temp_frango, "Frango"),
        Produto("Texas", 23.90F,R.drawable.ic_temp_burguer, "Carne"))



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