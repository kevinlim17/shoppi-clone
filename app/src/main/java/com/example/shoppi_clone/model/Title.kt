package com.example.shoppi_clone.model

import com.google.gson.annotations.SerializedName

data class Title(
    val text: String,
    //category_detail의 top_selling에서는 미사용
    @SerializedName("icon_url") val iconUrl: String?
)
