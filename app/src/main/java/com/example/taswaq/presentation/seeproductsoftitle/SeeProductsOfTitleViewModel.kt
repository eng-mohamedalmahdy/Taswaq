package com.example.taswaq.presentation.seeproductsoftitle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.taswaq.R
import com.example.taswaq.application.SeeProductsOfTypeRepository
import com.example.taswaq.application.constants.HomePageProductsListArgs
import kotlinx.coroutines.flow.map

class SeeProductsOfTitleViewModel(
    application: Application,
    private val repository: SeeProductsOfTypeRepository
) :
    AndroidViewModel(application) {
    fun getProperProductsList(productsType: String) =
        repository.getProperProductsList(productsType).map { it.products }

    fun getProperTitle(productsType: String) =
        when (productsType) {
            HomePageProductsListArgs.BEST_SELLER -> getApplication<Application>().getString(R.string.best_seller)
            HomePageProductsListArgs.FEATURED -> getApplication<Application>().getString(R.string.featured)
            HomePageProductsListArgs.WISHLIST ->  getApplication<Application>().getString(R.string.wishlist)
            else -> ""
        }

}
