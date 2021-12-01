package com.example.taswaq.presentation.seeallcategories

import androidx.lifecycle.ViewModel
import com.example.taswaq.application.SeeAllCategoriesRepository
import kotlinx.coroutines.flow.map

class SeeAllCategoriesViewModel(private val repository: SeeAllCategoriesRepository) : ViewModel() {
    val getCategoriesList = repository.getAllCategories().map { it.list }
}