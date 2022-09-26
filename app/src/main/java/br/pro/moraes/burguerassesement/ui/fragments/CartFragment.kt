package br.pro.moraes.burguerassesement.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.pro.moraes.burguerassesement.R
import br.pro.moraes.burguerassesement.data.CardapioAdapter
import br.pro.moraes.burguerassesement.data.CarrinhoAdapter
import br.pro.moraes.burguerassesement.databinding.FragmentCartBinding
import br.pro.moraes.burguerassesement.ui.BurguerViewModel

class CartFragment : Fragment() {

    val viewModel: BurguerViewModel by activityViewModels()

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val view = binding.root
        setupRecyclerView()
        setupObservers()
        return view
    }

    val adapter = CarrinhoAdapter()

    private fun setupRecyclerView() {
        binding.rvListaCarrinho.adapter = adapter
        binding.rvListaCarrinho.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    fun setupObservers(){
        viewModel.cardapio.observe(viewLifecycleOwner){
            adapter.submitList(
                viewModel.getCarrinho()
            )
            binding.rvListaCarrinho.adapter  = adapter
        }
    }


}