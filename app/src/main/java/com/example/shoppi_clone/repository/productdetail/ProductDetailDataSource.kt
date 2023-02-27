package com.example.shoppi_clone.repository.productdetail

import com.example.shoppi_clone.model.Product

interface ProductDetailDataSource {

    suspend fun getProductDetail(productId: String): Product
}