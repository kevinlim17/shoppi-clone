package com.example.shoppi_clone.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppi_clone.model.Product
import com.example.shoppi_clone.repository.productdetail.ProductDetailRepository
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val repository: ProductDetailRepository,
    private val productId: String
): ViewModel(){

    private val _productDetail = MutableLiveData<Product>()
    val productDetail: LiveData<Product> = _productDetail

    init {
        loadProductDetail()
    }

    private fun loadProductDetail(){
        viewModelScope.launch {
            val productDetailValue = repository.getProductDetail(productId)
            _productDetail.value = productDetailValue
        }
    }
}