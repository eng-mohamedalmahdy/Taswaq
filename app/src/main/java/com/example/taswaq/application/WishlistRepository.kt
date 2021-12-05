package com.example.taswaq.application

import com.example.taswaq.domain.dummyProducts
import kotlinx.coroutines.flow.MutableStateFlow

class WishlistRepository {
    fun getWishlist() = MutableStateFlow(dummyProducts)
}