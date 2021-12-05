package com.example.taswaq.presentation.wishlist

import androidx.lifecycle.ViewModel
import com.example.taswaq.application.WishlistRepository

class WishlistViewModel(private val repository: WishlistRepository) : ViewModel() {
    fun getWishlist() = repository.getWishlist()
}