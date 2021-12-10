package com.example.taswaq.application

import com.example.taswaq.application.adapters.domainProductToPresentationProduct
import com.example.taswaq.domain.dummyDomainProducts
import com.example.taswaq.presentation.seeproductsoftitle.model.SeeProductsOfTitleModel
import kotlinx.coroutines.flow.flow

class SeeProductsOfTypeRepository {
    fun getProperProductsList(productsType: String) = flow {
        emit(SeeProductsOfTitleModel(dummyDomainProducts.map(::domainProductToPresentationProduct)))
    }
}