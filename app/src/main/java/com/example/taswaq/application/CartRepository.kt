package com.example.taswaq.application

import com.example.taswaq.domain.model.DomainCart

class CartRepository {
    fun getCartItems() = DomainCart.cartItems

    fun getCartItemsCount() = DomainCart.itemsCount

    fun addToCart(itemId: Int) = DomainCart.addToCart(itemId)

    fun removeOneFromCart(itemId: Int) = DomainCart.removeOneFromCart(itemId)
    fun removeAllFromCart(itemId: Int) = DomainCart.removeAllFromCart(itemId)
}