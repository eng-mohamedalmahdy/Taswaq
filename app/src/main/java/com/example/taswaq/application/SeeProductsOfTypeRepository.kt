package com.example.taswaq.application

import com.example.taswaq.domain.dummyProducts
import com.example.taswaq.presentation.seeproductsoftitle.model.SeeProductsOfTitleModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow

class SeeProductsOfTypeRepository {
    fun getProperProductsList(productsType: String) = flow {
        emit(SeeProductsOfTitleModel(dummyProducts))
    }
}