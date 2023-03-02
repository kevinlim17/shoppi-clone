package com.example.shoppi_clone.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shoppi_clone.model.CartProduct

@Database(entities = [CartProduct::class], version = 1)
abstract class AppDataBase : RoomDatabase(){

    abstract fun cartProductDao(): CartProductDao
}