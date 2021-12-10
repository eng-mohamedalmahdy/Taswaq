package com.example.taswaq.application.adapters

import com.example.taswaq.domain.model.DomainProduct
import com.example.taswaq.presentation.common.model.PresentationProduct
import com.example.taswaq.presentation.productdetails.model.PresentationProductDetails

fun domainProductToPresentationProduct(domainProduct: DomainProduct) =
    PresentationProduct(
        id = domainProduct.id,
        name = domainProduct.name,
        imageUrl = domainProduct.images.firstOrNull() ?: "",
        price = domainProduct.priceAfterDiscount
    )

fun domainProductToPresentationProductDetails(domainProduct: DomainProduct) =
    PresentationProductDetails(
        productId = domainProduct.id,
        productTitle = domainProduct.name,
        productDescription = domainProduct.description,
        imagesUrls = domainProduct.images,
        productPriceBeforeDiscount = domainProduct.priceBeforeDiscount,
        productPriceAfterDiscount = domainProduct.priceAfterDiscount,
        productReviewsCount = domainProduct.rateCount,
        productRate = domainProduct.rate
    )