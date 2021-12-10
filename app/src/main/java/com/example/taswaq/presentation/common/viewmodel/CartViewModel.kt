package com.example.taswaq.presentation.common.viewmodel

import androidx.lifecycle.ViewModel
import com.example.taswaq.application.CartRepository
import com.example.taswaq.presentation.cart.model.PresentationCartItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class CartViewModel(private val repository: CartRepository) : ViewModel() {
    fun getCartItems(): Flow<List<PresentationCartItem>> = repository.getCartItems()
    fun getCartItemsCount(): Flow<Int> = repository.getCartItemsCount()
    fun addToCart(itemId: Int): Unit = repository.addToCart(itemId)
    fun removeAllFromCart(itemId: Int): Unit = repository.removeAllFromCart(itemId)
    fun removeOneFromCart(itemId: Int) = repository.removeOneFromCart(itemId)
}