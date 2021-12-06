package com.example.taswaq.presentation.myorders.model

import com.example.taswaq.R


data class Order(
    val orderThumbnail: String,
    val orderDate: String,
    val orderStatus: OrderStatus,
    val price: Double
) {
     enum class OrderStatus(val textValue: Int) {
        PENDING(R.string.pending),
        CONFIRMED(R.string.confirmed),
        SHIPPING(R.string.shipping),
        SHIPPED(R.string.shipped),
        CANCELLED(R.string.cancelled)
    }
}