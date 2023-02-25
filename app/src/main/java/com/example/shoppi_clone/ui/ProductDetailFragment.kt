package com.example.shoppi_clone.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shoppi_clone.R
import com.example.shoppi_clone.common.KEY_PRODUCT_ID

class ProductDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val testId = requireArguments().getString(KEY_PRODUCT_ID)
        Log.d("ProductDetailFragment", "Product: $testId")
    }
}