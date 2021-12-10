package com.example.taswaq.application

import com.example.taswaq.domain.dummyPresentationCategories
import com.example.taswaq.presentation.seeallcategories.model.SeeAllCategoriesModel
import kotlinx.coroutines.flow.flow

class SeeAllCategoriesRepository {
    fun getAllCategories() = flow {
        emit(SeeAllCategoriesModel(dummyPresentationCategories))
    }
}