package com.example.shoppi_clone.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.shoppi_clone.GlideApp
import com.example.shoppi_clone.R

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?){
    if (!imageUrl.isNullOrEmpty()){
        GlideApp.with(view)
            .load(imageUrl)
            .into(view)
    }
}

@BindingAdapter("circleImageUrl")
fun loadCircleImage(view: ImageView, imageUrl: String?){
    if (!imageUrl.isNullOrEmpty()){
        GlideApp.with(view)
            .load(imageUrl)
            .circleCrop()
            .into(view)
    }
}

@BindingAdapter("imageUrl", "radiusValue")
fun loadImageWithRadius(view: ImageView, imageUrl: String?, radiusValue: Int){
    if (!imageUrl.isNullOrEmpty()){
        GlideApp.with(view)
            .load(imageUrl)
            .transform(CenterCrop(), RoundedCorners(radiusValue))
            .into(view)
    }
}