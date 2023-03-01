package com.example.shoppi_clone.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.shoppi_clone.R
import com.example.shoppi_clone.databinding.FragmentCartBinding
import com.example.shoppi_clone.ui.common.ViewModelFactory

class CartFragment : Fragment() {

    private val viewModel: CartViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setAdapter()
    }

    private fun setAdapter() {
        val cartAdapter = CartAdapter()
        binding.rvCartItem.adapter = cartAdapter

        viewModel.products.observe(viewLifecycleOwner){ cartProducts ->
            cartAdapter.submitHeaderAndProductList(cartProducts)
        }
    }
}