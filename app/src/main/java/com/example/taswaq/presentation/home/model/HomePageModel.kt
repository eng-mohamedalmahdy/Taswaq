package com.example.taswaq.presentation.home.model

import com.example.taswaq.presentation.common.model.Category
import com.example.taswaq.presentation.common.model.Product

data class HomePageModel(
    val categories: List<Category>,
    val featuredProducts: List<Product>,
    val bestSeller: List<Product>
)
