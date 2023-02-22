package com.example.shoppi_clone.repository.categorydetail

import com.example.shoppi_clone.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail
}