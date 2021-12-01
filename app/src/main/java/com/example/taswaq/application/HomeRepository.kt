package com.example.taswaq.application

import com.example.taswaq.domain.dummyCategories
import com.example.taswaq.domain.dummyProducts
import com.example.taswaq.presentation.home.model.HomePageModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow

class HomeRepository {
    fun getHomePageModel() = flow {
        emit(
            HomePageModel(
                dummyCategories.shuffled(),
                dummyProducts.shuffled(),
                dummyProducts.shuffled()
            )
        )
    }
}