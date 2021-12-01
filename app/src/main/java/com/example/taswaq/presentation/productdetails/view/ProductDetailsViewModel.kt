package com.example.taswaq.presentation.productdetails.view

import androidx.lifecycle.ViewModel
import com.example.taswaq.application.ProductDetailsRepository
import kotlinx.coroutines.flow.map

class ProductDetailsViewModel(private val repository: ProductDetailsRepository) : ViewModel() {
    val images = repository.productDetailsModel.map { it.imagesUrls }
    val title = repository.productDetailsModel.map { it.productTitle }
    val priceBefore = repository.productDetailsModel.map { it.productPriceBeforeDiscount }
    val priceAfter = repository.productDetailsModel.map { it.productPriceAfterDiscount }
    val reviewsCount = repository.productDetailsModel.map { it.productReviewsCount }
    val rate = repository.productDetailsModel.map { it.productRate }
    val description = repository.productDetailsModel.map { it.productDescription }
}