package com.example.shoppi_clone.repository.categorydetail

import com.example.shoppi_clone.model.CategoryDetail

class CategoryDetailRepository(
    private val remoteDataSource: CategoryDetailRemoteDataSource
) {

    suspend fun getCategoryDetail(): CategoryDetail {
        return remoteDataSource.getCategoryDetail()
    }
}