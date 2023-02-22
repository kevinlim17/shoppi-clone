package com.example.shoppi_clone.repository.categorydetail

import com.example.shoppi_clone.model.CategoryDetail
import com.example.shoppi_clone.network.ApiClient

class CategoryDetailRemoteDataSource(private val apiClient: ApiClient) : CategoryDetailDataSource {

    override suspend fun getCategoryDetail(): CategoryDetail {
        return apiClient.getCategoryDetail()
    }
}