package com.example.taswaq.application

import com.example.taswaq.domain.dummyCategories
import com.example.taswaq.presentation.seeallcategories.model.SeeAllCategoriesModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class SeeAllCategoriesRepository {
    fun getAllCategories() = flow {
        emit(SeeAllCategoriesModel(dummyCategories))
    }
}