package com.example.shoppi_clone.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppi_clone.model.Product
import com.example.shoppi_clone.repository.cart.CartRepository
import com.example.shoppi_clone.repository.productdetail.ProductDetailRepository
import com.example.shoppi_clone.ui.common.Event
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository,
    private val cartRepository: CartRepository
): ViewModel(){

    private val _productDetail = MutableLiveData<Product>()
    val productDetail: LiveData<Product> = _productDetail

    private val _addCartEvent = MutableLiveData<Event<Unit>>()
    val addCartEvent: LiveData<Event<Unit>> = _addCartEvent

    fun loadProductDetail(productId: String){
        viewModelScope.launch {
            val productDetailValue = productDetailRepository.getProductDetail(productId)
            _productDetail.value = productDetailValue
        }
    }

    fun addCart(product: Product){
        viewModelScope.launch {
            cartRepository.addCartProduct(product)
            _addCartEvent.value = Event(Unit)
        }
    }
}