package com.example.shoppi_clone.ui.common

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.shoppi_clone.R
import java.text.DecimalFormat
import kotlin.math.roundToInt

@BindingAdapter("priceAmount")
fun applyPriceFormat(view: TextView, price: Int){
    val decimalFormat = DecimalFormat("#,###")
    view.text = view.context.getString(R.string.unit_discount_currency, decimalFormat.format(price))
}

@BindingAdapter("strikePriceAmount")
fun applyStrikePriceFormat(view: TextView, price: Int){
    applyPriceFormat(view, price)
    view.paintFlags = view.paintFlags.or(Paint.STRIKE_THRU_TEXT_FLAG)
}

@BindingAdapter("priceAmount", "discountRate")
fun applyPriceDiscountRate(view: TextView, price: Int, discountRate: Int){
    val discountPrice = (((100 - discountRate) / 100.0 ) * price).roundToInt()
    applyPriceFormat(view, discountPrice)
}