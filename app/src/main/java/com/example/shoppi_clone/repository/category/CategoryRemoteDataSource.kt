package com.example.shoppi_clone.repository.category

import com.example.shoppi_clone.model.Category
import com.example.shoppi_clone.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient) : CategoryDataSource {

    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}