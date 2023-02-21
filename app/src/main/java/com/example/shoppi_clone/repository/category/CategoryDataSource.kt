package com.example.shoppi_clone.repository.category

import com.example.shoppi_clone.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>
}