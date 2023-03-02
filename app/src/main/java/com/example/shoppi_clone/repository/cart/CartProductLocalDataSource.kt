package com.example.shoppi_clone.repository.cart

import com.example.shoppi_clone.database.CartProductDao
import com.example.shoppi_clone.model.CartProduct

class CartProductLocalDataSource(
    private val dao: CartProductDao
) : CartProductDataSource{

    override suspend fun addCartProduct(cartProduct: CartProduct) {
        dao.insert(cartProduct)
    }

    override suspend fun getCartProducts(): List<CartProduct> {
        return dao.load()
    }

}