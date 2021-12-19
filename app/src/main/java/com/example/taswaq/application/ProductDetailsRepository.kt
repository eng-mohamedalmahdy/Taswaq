package com.example.taswaq.application

import com.example.taswaq.application.adapters.domainProductToPresentationProductDetails
import com.example.taswaq.domain.dummyDomainProducts
import com.example.taswaq.presentation.productdetails.model.PresentationProductDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductDetailsRepository {
    fun getProductDetailsModel(productId: Int): Flow<PresentationProductDetails> =
        flow {
             emit(domainProductToPresentationProductDetails(
               dummyDomainProducts.first { productId == it.id }))
    }
}