package com.example.taswaq.presentation.productdetails.model

data class ProductDetailsModel(
    val imagesUrls: List<String>,
    val productTitle: String,
    val productPriceBeforeDiscount: Double,
    val productPriceAfterDiscount: Double,
    val productDescription: String,
    val productRate: Double,
    val productReviewsCount: Int
)
