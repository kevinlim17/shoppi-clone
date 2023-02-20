package com.example.shoppi_clone.repository

import com.example.shoppi_clone.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}