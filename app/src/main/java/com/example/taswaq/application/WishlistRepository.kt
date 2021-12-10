package com.example.taswaq.application

import com.example.taswaq.application.adapters.domainProductToPresentationProduct
import com.example.taswaq.domain.dummyDomainProducts
import kotlinx.coroutines.flow.MutableStateFlow

class WishlistRepository {
    fun getWishlist() =
        MutableStateFlow(dummyDomainProducts.map(::domainProductToPresentationProduct))
}