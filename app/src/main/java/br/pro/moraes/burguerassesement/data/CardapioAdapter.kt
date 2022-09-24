package br.pro.moraes.burguerassesement.data


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import br.pro.moraes.burguerassesement.databinding.CardapioItemListBinding


class CardapioAdapter: ListAdapter<Produto, CardapioAdapter.ViewHolder> (ProdutoDiffCallBack()) {


    class ViewHolder private constructor( val binding: CardapioItemListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Produto) {
            val preco_form = item.preco.toString().replace('.', ',')
            binding.tvNomeProduto.text = item.nome
            binding.tvPrecoProduto.text = "R$${preco_form}"
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CardapioItemListBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}


class ProdutoDiffCallBack : DiffUtil.ItemCallback<Produto>() {
    override fun areItemsTheSame(oldItem: Produto, newItem: Produto): Boolean {
        return oldItem.nome == newItem.nome
    }

    override fun areContentsTheSame(oldItem: Produto, newItem: Produto): Boolean {
        return oldItem == newItem
    }

}