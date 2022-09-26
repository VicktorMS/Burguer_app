package br.pro.moraes.burguerassesement.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pro.moraes.burguerassesement.R
import br.pro.moraes.burguerassesement.data.Produto

class BurguerViewModel: ViewModel() {
    val cardapioLista = mutableListOf<Produto>(
        Produto("Cheese Burguer", 12.90F, R.drawable.ic_temp_frango, "Frango", 0),
        Produto("American", 19.00F, R.drawable.ic_temp_burguer, "Carne", 0),
        Produto("Bacon Burguer", 18.00F, R.drawable.ic_temp_burguer, "Carne", 2),
        Produto("Veg Burguer", 15.00F, R.drawable.ic_temp_frango, "Vegetariano", 1),
        Produto("Chicken Burguer", 16.00F, R.drawable.ic_temp_frango, "Frango", 0),
        Produto("Texas", 23.90F,R.drawable.ic_temp_burguer, "Carne", 0))

    val cardapio = MutableLiveData<List<Produto>>()
    private val _textoCompartilhado = MutableLiveData<String>("")
    val textoCompartilhado: LiveData<String> = _textoCompartilhado

    init {
        cardapio.value = cardapioLista

    }

    fun setTextoCompartilhado(value: String) {
        _textoCompartilhado.postValue(value)
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

    fun getCarrinho(): List<Produto>{
        return cardapio.value!!.filter {
            it.quantidade >= 1
        }
    }

    fun PedidoTexto(lista: List<Produto>) : String {
        var texto = ""
        var preco_total: Float = 0.0F
        lista.forEach {
            texto+= "Nome: ${it.nome} | Qnt: ${it.quantidade} | Preço: ${it.preco}\n"
            if (it.quantidade >= 1){preco_total += (it.quantidade.toFloat() * it.preco)}
            else{ preco_total += it.preco }
        }

        texto += "Preço Total: $preco_total\n"

        return texto.toString()
    }

    fun compartilharPedido(){
        val texto = PedidoTexto(getCarrinho())
        setTextoCompartilhado(texto)
    }










}