package com.example.shoppi_clone

import android.content.Context
import androidx.room.Room
import com.example.shoppi_clone.database.AppDataBase
import com.example.shoppi_clone.network.ApiClient
import com.example.shoppi_clone.repository.cart.CartProductLocalDataSource
import com.example.shoppi_clone.repository.cart.CartRepository

object ServiceLocator {

    private var apiClient: ApiClient? = null
    private var dataBase: AppDataBase? = null
    private var cartRepository: CartRepository? = null

    //ApiClient Instance 재사용 위함
    fun provideApiClient(): ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }

    //AppDataBase Instance 재사용 위함
    private fun provideDatabase(applicationContext: Context): AppDataBase {
        return dataBase ?: kotlin.run {
            Room.databaseBuilder(applicationContext,
                AppDataBase::class.java,
                "shoppi-clone-local"
            ).build().also {
                dataBase = it
            }
        }
    }

    fun provideCartRepository(context: Context): CartRepository {
        return cartRepository ?: kotlin.run {
            val dao = provideDatabase(context.applicationContext).cartProductDao()
            CartRepository(CartProductLocalDataSource(dao)).also {
                cartRepository = it
            }
        }
    }
}