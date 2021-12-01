package com.example.taswaq.application

import com.example.taswaq.domain.dummyProductDetails
import kotlinx.coroutines.flow.flow

class ProductDetailsRepository {
    val productDetailsModel = flow {
        emit(dummyProductDetails)
    }
}