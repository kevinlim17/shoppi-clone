package com.example.shoppi_clone.repository.home

import com.example.shoppi_clone.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}