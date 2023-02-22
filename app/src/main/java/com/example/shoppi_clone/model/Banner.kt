package com.example.shoppi_clone.model

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("background_image_url") val backgroundImageUrl: String,
    val badge: BannerBadge,
    val label: String,
    @SerializedName("product_detail") val productDetail: Product
)

data class BannerBadge(
    val label: String,
    @SerializedName("background_color") val backgroundColor: String
)

data class Product(
    //category_detail의 promotions에서는 미사용
    @SerializedName("brand_name") val brandName: String?,
    val label: String,
    @SerializedName("discount_rate") val discountRate: Int,
    val price: Int,
    //category_detail의 promotions에서는 미사용
    @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String?,
    //home banner에서는 미사용
    @SerializedName("representative_image_url") val representativeImageUrl: String?,
    @SerializedName("product_id") val productId: String
)