package com.example.shoppi_clone.database

import androidx.room.*
import com.example.shoppi_clone.model.CartProduct

@Dao
interface CartProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cartProduct: CartProduct)

    @Query("SELECT * FROM cart_product")
    suspend fun load(): List<CartProduct>

    /** 추가 구현 필요
    @Delete
    suspend fun delete()
    */
}
