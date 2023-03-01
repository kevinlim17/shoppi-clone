package com.example.shoppi_clone.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppi_clone.databinding.ItemCartProductBinding
import com.example.shoppi_clone.databinding.ItemCartSectionHeaderBinding
import com.example.shoppi_clone.model.CartData
import com.example.shoppi_clone.model.CartHeader
import com.example.shoppi_clone.model.CartProduct

private const val VIEW_TYPE_HEADER = 0
private const val VIEW_TYPE_PRODUCT = 1


class CartAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val cartDataList = mutableListOf<CartData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            VIEW_TYPE_HEADER -> HeaderViewHolder(ItemCartSectionHeaderBinding.inflate(inflater, parent, false))
            else -> ProductViewHolder(ItemCartProductBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is HeaderViewHolder -> {
                val item = cartDataList[position] as CartHeader
                holder.bind(item)
            }
            is ProductViewHolder -> {
                val item = cartDataList[position] as CartProduct
                holder.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (cartDataList[position]) {
            is CartHeader -> VIEW_TYPE_HEADER
            is CartProduct -> VIEW_TYPE_PRODUCT
        }
    }

    override fun getItemCount(): Int {
        return cartDataList.size
    }

    fun submitHeaderAndProductList(cartProducts: List<CartProduct>){
        val cartProductGroups = cartProducts.groupBy { it.brandName }
        val dataList = mutableListOf<CartData>()

        cartProductGroups.entries.forEach { entry ->
            val header = CartHeader(entry.key)
            dataList.add(header)
            dataList.addAll(entry.value)
        }
        cartDataList.addAll(dataList)
        notifyItemRangeInserted(cartDataList.size, dataList.size)
    }

    class HeaderViewHolder(private val binding: ItemCartSectionHeaderBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(header: CartHeader){
            binding.header = header
            binding.executePendingBindings()
        }
    }

    class ProductViewHolder(private val binding: ItemCartProductBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(cartProduct: CartProduct){
            binding.cartProduct = cartProduct
            binding.executePendingBindings()
        }
    }

}