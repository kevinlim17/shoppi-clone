package com.example.shoppi_clone

import com.example.shoppi_clone.network.ApiClient

object ServiceLocator {

    private var apiClient: ApiClient? = null

    //ApiClient Instance 재사용 위함
    fun provideApiClient(): ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }
}