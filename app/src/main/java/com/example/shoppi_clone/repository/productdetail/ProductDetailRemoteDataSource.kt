package com.example.shoppi_clone.repository.productdetail

import android.util.Log
import com.example.shoppi_clone.model.Product
import com.example.shoppi_clone.network.ApiClient

class ProductDetailRemoteDataSource(private val apiClient: ApiClient) : ProductDetailDataSource {

    override suspend fun getProductDetail(productId: String): Product {
        return apiClient.getProductDetail(productId)
    }
}