package com.example.shoppi_clone.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppi_clone.model.CartProduct
import com.example.shoppi_clone.repository.cart.CartRepository
import kotlinx.coroutines.launch

class CartViewModel(
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _products = MutableLiveData<List<CartProduct>>()
    val products: LiveData<List<CartProduct>> = _products

    init {
        loadCartItem()
    }

    private fun loadCartItem() {
        viewModelScope.launch {
            _products.value = cartRepository.getCartProducts()
        }
    }

}