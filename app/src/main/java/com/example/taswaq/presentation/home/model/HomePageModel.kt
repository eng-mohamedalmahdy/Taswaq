package com.example.taswaq.presentation.home.model

import com.example.taswaq.presentation.common.model.PresentationCategory
import com.example.taswaq.presentation.common.model.PresentationProduct

data class HomePageModel(
    val categories: List<PresentationCategory>,
    val featuredProducts: List<PresentationProduct>,
    val bestSeller: List<PresentationProduct>
)
