package com.example.taswaq.presentation.core

import android.app.Application
import com.example.taswaq.application.*
import com.example.taswaq.presentation.auth.signin.LogInViewModel
import com.example.taswaq.presentation.home.HomeViewModel
import com.example.taswaq.presentation.myorders.MyOrdersViewModel
import com.example.taswaq.presentation.productdetails.view.ProductDetailsViewModel
import com.example.taswaq.presentation.seeallcategories.SeeAllCategoriesViewModel
import com.example.taswaq.presentation.seeproductsoftitle.SeeProductsOfTitleViewModel
import com.example.taswaq.presentation.wishlist.WishlistViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class TaswaqApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TaswaqApplication)
            modules(appModule)
        }
    }
}

val appModule = module {
    //Home Page
    single { HomeRepository() }
    viewModel { HomeViewModel(get()) }

    //See all featured or best seller
    single { SeeProductsOfTypeRepository() }
    viewModel { SeeProductsOfTitleViewModel(get(), get()) }

    //See all categories
    single { SeeAllCategoriesRepository() }
    viewModel { SeeAllCategoriesViewModel(get()) }

    //Product details
    single { ProductDetailsRepository() }
    viewModel { ProductDetailsViewModel(get()) }

    //Sign in
    single { LogInRepository() }
    viewModel { LogInViewModel(get()) }

    //wishlist
    single { WishlistRepository() }
    viewModel { WishlistViewModel(get()) }

    //ordersList
    single { MyOrdersRepository() }
    viewModel { MyOrdersViewModel(get()) }
}