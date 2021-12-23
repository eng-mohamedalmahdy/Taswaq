package com.example.taswaq.application

import com.example.taswaq.domain.model.DomainCart

class CartRepository {
    //TODO Make it Domain cart item
    fun getCartItems() = DomainCart.cartItems

    fun getCartItemsCount() = DomainCart.itemsCount
    fun getCartItemsPrice() =  DomainCart.cartItemsPrice

    fun addToCart(itemId: Int) = DomainCart.addToCart(itemId)

    fun removeOneFromCart(itemId: Int) = DomainCart.removeOneFromCart(itemId)
    fun removeAllFromCart(itemId: Int) = DomainCart.removeAllFromCart(itemId)

}