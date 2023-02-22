package com.example.shoppi_clone.ui.common

import androidx.recyclerview.widget.DiffUtil
import com.example.shoppi_clone.model.Category

class CategoryDiffCallback : DiffUtil.ItemCallback<Category>(){
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

}