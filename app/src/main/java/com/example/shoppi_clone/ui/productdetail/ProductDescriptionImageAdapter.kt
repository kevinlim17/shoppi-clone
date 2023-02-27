package com.example.shoppi_clone.ui.productdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppi_clone.databinding.ItemProductDetailImageBinding
import com.example.shoppi_clone.model.DescriptionImage

class ProductDescriptionImageAdapter() :
    ListAdapter<DescriptionImage, ProductDescriptionImageAdapter.DescriptionImageViewHolder>(
        DescriptionImageDiffCallback()
    ) {

    private lateinit var binding: ItemProductDetailImageBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionImageViewHolder {
        binding = ItemProductDetailImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DescriptionImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DescriptionImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DescriptionImageViewHolder(private val binding: ItemProductDetailImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(descriptionImage: DescriptionImage) {
            binding.descriptionImage = descriptionImage
            binding.executePendingBindings()
        }

    }

}

class DescriptionImageDiffCallback : DiffUtil.ItemCallback<DescriptionImage>() {
    override fun areItemsTheSame(oldItem: DescriptionImage, newItem: DescriptionImage): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DescriptionImage, newItem: DescriptionImage): Boolean {
        return oldItem == newItem
    }

}