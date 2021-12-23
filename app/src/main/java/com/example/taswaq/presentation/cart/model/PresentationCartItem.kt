package com.example.taswaq.presentation.cart.model

data class PresentationCartItem(
    val id: Int,
    val productImageUrl: String,
    val productName: String,
    val productBrand: String,
    val productUnitPrice: Double,
    var productQty: Int,
    var discount:Double
) {
    fun getTotalPrice() = productQty * productUnitPrice
    fun inc() {
        productQty++
    }

    fun dec() {
        productQty--
    }
}
