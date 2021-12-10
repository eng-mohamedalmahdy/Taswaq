package com.example.taswaq.presentation.productdetails.view

import androidx.lifecycle.ViewModel
import com.example.taswaq.application.ProductDetailsRepository
import kotlinx.coroutines.flow.map

class ProductDetailsViewModel(
    private val repository: ProductDetailsRepository,
    private val productId: Int
) : ViewModel() {
    val images = repository.getProductDetailsModel(productId).map { it.imagesUrls }
    val title = repository.getProductDetailsModel(productId).map { it.productTitle }
    val priceBefore =
        repository.getProductDetailsModel(productId).map { it.productPriceBeforeDiscount }
    val priceAfter =
        repository.getProductDetailsModel(productId).map { it.productPriceAfterDiscount }
    val reviewsCount = repository.getProductDetailsModel(productId).map { it.productReviewsCount }
    val rate = repository.getProductDetailsModel(productId).map { it.productRate }
    val description = repository.getProductDetailsModel(productId).map { it.productDescription }
    val id = repository.getProductDetailsModel(productId).map { it.productId }
}