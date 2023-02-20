package com.example.shoppi_clone.model

import com.google.gson.annotations.SerializedName

data class HomeData(
    val title: Title,
    @SerializedName("top_banners") val topBanners: List<Banner>
)
