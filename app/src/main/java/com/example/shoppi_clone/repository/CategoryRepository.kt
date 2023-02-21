package com.example.shoppi_clone.repository

import com.example.shoppi_clone.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository(
    private val remoteDataSource: CategoryRemoteDataSource
) {

    // suspend: Coroutine Scope에서만 Method가 실행되도록 함.
    suspend fun getCategories(): List<Category> {

        /**Coroutine이 실행될 Thread 변경, Retrofit2 사용시 필요 X
        withContext(Dispatchers.IO) {
            remoteDataSource.getCategories()
        }
        */
        return remoteDataSource.getCategories()
    }
}