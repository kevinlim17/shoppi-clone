package com.example.shoppi_clone.ui.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppi_clone.model.Category
import com.example.shoppi_clone.repository.category.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository): ViewModel() {

    private val _items = MutableLiveData<List<Category>>()
    val items: MutableLiveData<List<Category>> = _items

    init {
        loadCategory()
    }

    private fun loadCategory() {
        //TODO Repository에 데이터 요청
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            _items.value = categories
        }
    }
}