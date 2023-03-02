package com.example.shoppi_clone.repository.cart

import com.example.shoppi_clone.model.CartProduct
import com.example.shoppi_clone.model.Product
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartRepository(
    private val localDataSource: CartProductLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun addCartProduct(product: Product){
        //Thread 변경
        withContext(ioDispatcher) {
            val cartProduct = CartProduct(
                productId = product.productId,
                label = product.label,
                price = product.price,
                brandName = product.brandName ?: "",
                thumbnailImageUrl = product.thumbnailImageUrl ?: "",
                type = product.type ?: "",
                amount = 1 //상품 개수 가감 시 추가 구현 필요
            )
            localDataSource.addCartProduct(cartProduct)
        }
    }

    suspend fun getCartProducts(): List<CartProduct> {
        //Thread 변경
        return withContext(ioDispatcher) {
            localDataSource.getCartProducts()
        }
    }

}