package com.example.shoppi_clone.ui.common

import androidx.databinding.BindingAdapter
import android.view.View

@BindingAdapter("isVisible")
fun updateVisibility(view: View, isVisible: Boolean){
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}