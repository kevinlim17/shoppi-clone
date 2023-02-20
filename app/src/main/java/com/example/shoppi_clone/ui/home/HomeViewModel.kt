package com.example.shoppi_clone.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppi_clone.model.Banner
import com.example.shoppi_clone.model.Title
import com.example.shoppi_clone.repository.HomeRepository

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        // TODO Data Layer - Repository에 요청
        val homeData = homeRepository.getHomeData()
        homeData?.let {
            _title.value = it.title
            _topBanners.value = it.topBanners
        }

    }


}