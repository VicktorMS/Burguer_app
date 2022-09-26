package br.pro.moraes.burguerassesement.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import br.pro.moraes.burguerassesement.R
import br.pro.moraes.burguerassesement.databinding.FragmentCompartilharBinding
import br.pro.moraes.burguerassesement.ui.BurguerViewModel

class CompartilharFragment : Fragment() {


    val viewModel: BurguerViewModel by activityViewModels()

    private var _binding: FragmentCompartilharBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompartilharBinding.inflate(inflater, container, false)
        val view = binding.root
        setupClickListeners()

        return view
    }

    private fun setupClickListeners() {
            binding.btnCompartilharPedido.setOnClickListener {
                Log.i("Bazinga", "Bazinga")
                viewModel.compartilharPedido()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}