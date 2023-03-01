package com.example.shoppi_clone.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppi_clone.model.CartProduct

class CartViewModel : ViewModel() {

    private val _products = MutableLiveData<List<CartProduct>>()
    val products: LiveData<List<CartProduct>> = _products

    fun loadCartItem() {
        _products.value
    }

}