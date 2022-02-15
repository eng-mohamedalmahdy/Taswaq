package com.example.taswaq.application.adapters

import com.example.taswaq.domain.model.DomainAddress
import com.example.taswaq.domain.model.DomainCategory
import com.example.taswaq.domain.model.DomainProduct
import com.example.taswaq.domain.model.DomainProfile
import com.example.taswaq.presentation.common.model.PresentationCategory
import com.example.taswaq.presentation.common.model.PresentationProduct
import com.example.taswaq.presentation.productdetails.model.PresentationProductDetails
import com.example.taswaq.presentation.profile.model.PresentationProfile

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

fun domainProfileToPresentationProfile(domainProfile: DomainProfile) =
    PresentationProfile(
        firstName = domainProfile.firstname,
        lastName = domainProfile.lastName,
        email = domainProfile.email,
        phoneNumber = domainProfile.phoneNumber
    )

fun domainCategoryToPresentationCategory(domainCategory: DomainCategory) =
    PresentationCategory(
        domainCategory.name ?: "None",
        domainCategory.color ?: "#374ABE",
        domainCategory.image ?: ""
    )

fun domainAddressToPresentationAddress(domainAddress: DomainAddress) {}