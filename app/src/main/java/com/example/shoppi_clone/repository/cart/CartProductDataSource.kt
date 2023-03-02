package com.example.shoppi_clone.repository.cart

import com.example.shoppi_clone.model.CartProduct

interface CartProductDataSource {

    suspend fun addCartProduct(cartProduct: CartProduct)

    suspend fun getCartProducts(): List<CartProduct>
}