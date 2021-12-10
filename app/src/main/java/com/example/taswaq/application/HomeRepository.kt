package com.example.taswaq.application

import com.example.taswaq.application.adapters.domainProductToPresentationProduct
import com.example.taswaq.domain.dummyDomainProducts
import com.example.taswaq.domain.dummyPresentationCategories
import com.example.taswaq.presentation.home.model.HomePageModel
import kotlinx.coroutines.flow.flow

class HomeRepository {
    fun getHomePageModel() = flow {
        emit(
            HomePageModel(
                dummyPresentationCategories.shuffled(),
                dummyDomainProducts.map(::domainProductToPresentationProduct).shuffled(),
                dummyDomainProducts.map(::domainProductToPresentationProduct).shuffled()
            )
        )
    }
}