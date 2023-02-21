package com.example.shoppi_clone.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppi_clone.AssetLoader
import com.example.shoppi_clone.network.ApiClient
import com.example.shoppi_clone.repository.CategoryRemoteDataSource
import com.example.shoppi_clone.repository.CategoryRepository
import com.example.shoppi_clone.repository.HomeAssetDataSource
import com.example.shoppi_clone.repository.HomeRepository
import com.example.shoppi_clone.ui.category.CategoryViewModel
import com.example.shoppi_clone.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                CategoryViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}