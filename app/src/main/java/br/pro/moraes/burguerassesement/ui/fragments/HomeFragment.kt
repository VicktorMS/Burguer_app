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
import br.pro.moraes.burguerassesement.databinding.FragmentHomeBinding
import br.pro.moraes.burguerassesement.ui.BurguerViewModel

class HomeFragment : Fragment() {
    val viewModel: BurguerViewModel by activityViewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        setupRecyclerView()
        setupObservers()

        return view

    }

    val adapter = CardapioAdapter()

    private fun setupRecyclerView() {
        binding.rvCardapioHome.adapter = adapter
        binding.rvCardapioHome.layoutManager = GridLayoutManager(
            requireContext(),2,LinearLayoutManager.VERTICAL,false)
    }

    fun setupObservers(){
        viewModel.cardapio.observe(viewLifecycleOwner){
            adapter.submitList(it)
            binding.rvCardapioHome.adapter = adapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}