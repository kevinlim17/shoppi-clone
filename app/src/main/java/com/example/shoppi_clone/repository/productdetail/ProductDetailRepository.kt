package com.example.shoppi_clone.repository.productdetail

import com.example.shoppi_clone.model.Product

class ProductDetailRepository(
    private val remoteDataSource: ProductDetailRemoteDataSource
) {

    suspend fun getProductDetail(productId: String): Product {
        return remoteDataSource.getProductDetail(productId)
    }
}