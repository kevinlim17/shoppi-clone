package com.example.shoppi_clone.model

sealed class CartData

data class CartHeader(
    val brandName: String
): CartData()

data class CartProduct(
    val productId: String,
    val label: String,
    val price: Int,
    val brandName: String,
    val thumbnailImageUrl: String,
    val type: String,
    val amount: Int
): CartData()