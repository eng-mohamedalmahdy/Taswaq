package com.example.taswaq.domain.model

data class DomainProduct(
    val id: Int,
    val name: String,
    val description: String,
    val brand: String,
    val images: List<String>,
    val priceBeforeDiscount: Double,
    val priceAfterDiscount: Double,
    val rate: Double,
    val rateCount: Int,
    val discount: Double
)
