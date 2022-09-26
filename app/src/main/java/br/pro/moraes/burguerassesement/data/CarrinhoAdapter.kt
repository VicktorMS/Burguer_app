package br.pro.moraes.burguerassesement.data


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import br.pro.moraes.burguerassesement.databinding.CardapioItemListBinding
import br.pro.moraes.burguerassesement.databinding.CartItemListBinding
import br.pro.moraes.burguerassesement.ui.BurguerViewModel


class CarrinhoAdapter: ListAdapter<Produto, CarrinhoAdapter.ViewHolder> (ProdutoCarrinhoDiffCallBack()) {
    
    class ViewHolder private constructor( val binding: CartItemListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Produto) {
            val preco_form = item.preco.toString().replace('.', ',')
            binding.tvNomeProduto.text = item.nome
            binding.imgvProduto.setImageResource(item.img)
            binding.tvPrecoProduto.text = "R$${preco_form}"
            binding.btnAddQnt.setOnClickListener{item.quantidade + 1}
            binding.btnRetirarQnt.setOnClickListener{item.quantidade - 1}
            binding.tvQuantidade.text = item.quantidade.toString()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CartItemListBinding.inflate(layoutInflater, parent, false)

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


class ProdutoCarrinhoDiffCallBack : DiffUtil.ItemCallback<Produto>() {
    override fun areItemsTheSame(oldItem: Produto, newItem: Produto): Boolean {
        return oldItem.nome == newItem.nome
    }

    override fun areContentsTheSame(oldItem: Produto, newItem: Produto): Boolean {
        return oldItem == newItem
    }

}