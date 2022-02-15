package com.example.taswaq.application

import com.example.taswaq.application.adapters.domainCategoryToPresentationCategory
import com.example.taswaq.domain.dummyPresentationCategories
import com.example.taswaq.domain.network.TaswaqAPI
import com.example.taswaq.presentation.seeallcategories.model.SeeAllCategoriesModel
import kotlinx.coroutines.flow.flow

class SeeAllCategoriesRepository(private val api: TaswaqAPI) {
    fun getAllCategories() = flow {
        emit(SeeAllCategoriesModel(api.getAllCategories().data.categories.map(::domainCategoryToPresentationCategory)))
    }
}