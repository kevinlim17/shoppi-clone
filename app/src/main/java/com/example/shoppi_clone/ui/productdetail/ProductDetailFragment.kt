package com.example.shoppi_clone.ui.productdetail

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shoppi_clone.R
import com.example.shoppi_clone.common.KEY_PRODUCT_ID
import com.example.shoppi_clone.databinding.FragmentProductDetailBinding
import com.example.shoppi_clone.ui.common.Event
import com.example.shoppi_clone.ui.common.EventObserver
import com.example.shoppi_clone.ui.common.ViewModelFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProductDetailFragment : Fragment() {

    private val viewModel: ProductDetailViewModel by viewModels {
        ViewModelFactory(requireContext())
    }
    private lateinit var binding: FragmentProductDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        setNavigation()
        requireArguments().getString(KEY_PRODUCT_ID)?.let { productId ->
            setProductDetail(productId)
        }
        setAddCart()
    }

    private fun setNavigation() {
        binding.toolbarProductDetail.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setProductDetail(productId: String) {
        viewModel.loadProductDetail(productId)

        val productDescriptionImageAdapter = ProductDescriptionImageAdapter()
        binding.rvProductDetailImages.adapter = productDescriptionImageAdapter

        viewModel.productDetail.observe(viewLifecycleOwner) { product ->
            binding.productDetail = product
            productDescriptionImageAdapter.submitList(product.descriptions)
        }
    }

    private fun setAddCart(){
        viewModel.addCartEvent.observe(viewLifecycleOwner, EventObserver {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("??????????????? ????????? ???????????????")
                .setPositiveButton("??????") { dialog, which ->

                }
                .show()
        })
    }

}