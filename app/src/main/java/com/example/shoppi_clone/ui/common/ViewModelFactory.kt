package com.example.shoppi_clone.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppi_clone.AssetLoader
import com.example.shoppi_clone.network.ApiClient
import com.example.shoppi_clone.repository.category.CategoryRemoteDataSource
import com.example.shoppi_clone.repository.category.CategoryRepository
import com.example.shoppi_clone.repository.categorydetail.CategoryDetailRemoteDataSource
import com.example.shoppi_clone.repository.categorydetail.CategoryDetailRepository
import com.example.shoppi_clone.repository.home.HomeAssetDataSource
import com.example.shoppi_clone.repository.home.HomeRepository
import com.example.shoppi_clone.repository.productdetail.ProductDetailRemoteDataSource
import com.example.shoppi_clone.repository.productdetail.ProductDetailRepository
import com.example.shoppi_clone.ui.category.CategoryViewModel
import com.example.shoppi_clone.ui.categorydetail.CategoryDetailViewModel
import com.example.shoppi_clone.ui.home.HomeViewModel
import com.example.shoppi_clone.ui.productdetail.ProductDetailViewModel

class ViewModelFactory(
    private val context: Context,
    private val initValue: String?
) : ViewModelProvider.Factory {
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
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository = CategoryDetailRepository(CategoryDetailRemoteDataSource(ApiClient.create()))
                CategoryDetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ProductDetailViewModel::class.java) && !initValue.isNullOrEmpty() -> {
                val repository = ProductDetailRepository(ProductDetailRemoteDataSource(ApiClient.create()))
                ProductDetailViewModel(repository, initValue) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}