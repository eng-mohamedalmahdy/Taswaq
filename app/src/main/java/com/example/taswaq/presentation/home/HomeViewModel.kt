package com.example.taswaq.presentation.home

import androidx.lifecycle.ViewModel
import com.example.taswaq.application.HomeRepository
import kotlinx.coroutines.flow.map

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    val categories = repository.getHomePageModel().map { it.categories }
    val featured = repository.getHomePageModel().map { it.featuredProducts }
    val bestSellers = repository.getHomePageModel().map { it.bestSeller }

}