package com.example.shoppi_clone.repository

import com.example.shoppi_clone.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>
}