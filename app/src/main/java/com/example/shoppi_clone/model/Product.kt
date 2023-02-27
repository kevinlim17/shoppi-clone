package com.example.shoppi_clone.model

import com.google.gson.annotations.SerializedName

data class Product(
    //category_detail의 promotions에서는 미사용
    @SerializedName("brand_name") val brandName: String?,
    val label: String,
    @SerializedName("discount_rate") val discountRate: Int,
    val price: Int,
    //product_detail에서만 사용
    val type: String?,
    //category_detail의 promotions에서는 미사용
    @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String?,
    //home banner에서는 미사용
    @SerializedName("representative_image_url") val representativeImageUrl: String?,
    @SerializedName("product_id") val productId: String,
    //product_detail에서만 사용
    val descriptions: List<DescriptionImage>?
)

data class DescriptionImage(
    val id: String,
    @SerializedName("image_url") val imageUrl: String
)
