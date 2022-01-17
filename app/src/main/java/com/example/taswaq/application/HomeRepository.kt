package com.example.taswaq.application

import com.example.taswaq.application.adapters.domainCategoryToPresentationCategory
import com.example.taswaq.application.adapters.domainProductToPresentationProduct
import com.example.taswaq.domain.dummyDomainProducts
import com.example.taswaq.domain.network.TaswaqAPI
import com.example.taswaq.presentation.home.model.HomePageModel
import kotlinx.coroutines.flow.flow

class HomeRepository(private val api: TaswaqAPI) {
    fun getHomePageModel() = flow {
        emit(
            HomePageModel(
                api.getAllCategories().data.categories.map(::domainCategoryToPresentationCategory),
                dummyDomainProducts.map(::domainProductToPresentationProduct).shuffled(),
                dummyDomainProducts.map(::domainProductToPresentationProduct).shuffled()
            )
        )
    }
}