package com.example.shoppi_clone.ui.categorydetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppi_clone.databinding.ItemCategoryTopSellingBinding
import com.example.shoppi_clone.model.Category
import com.example.shoppi_clone.ui.common.CategoryDiffCallback

class CategoryTopSellingItemAdapter: ListAdapter<Category, CategoryTopSellingItemAdapter.TopSellingItemViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopSellingItemViewHolder {
        val binding = ItemCategoryTopSellingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopSellingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopSellingItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TopSellingItemViewHolder(private val binding: ItemCategoryTopSellingBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(category: Category){
            binding.category = category
            binding.executePendingBindings()
        }
    }
}
