package com.example.taswaq.domain.core

import android.app.Application
import com.example.taswaq.application.*
import com.example.taswaq.domain.constants.NetworkConstants.BASE_URL
import com.example.taswaq.domain.network.AuthInterceptor
import com.example.taswaq.domain.network.TaswaqAPI
import com.example.taswaq.presentation.address.viewmodel.AddressViewModel
import com.example.taswaq.presentation.address.viewmodel.CreateAddressViewModel
import com.example.taswaq.presentation.auth.signin.LogInViewModel
import com.example.taswaq.presentation.common.viewmodel.CartViewModel
import com.example.taswaq.presentation.home.HomeViewModel
import com.example.taswaq.presentation.myorders.MyOrdersViewModel
import com.example.taswaq.presentation.payment.viewModel.PaymentViewModel
import com.example.taswaq.presentation.productdetails.view.ProductDetailsViewModel
import com.example.taswaq.presentation.seeallcategories.SeeAllCategoriesViewModel
import com.example.taswaq.presentation.seeproductsoftitle.SeeProductsOfTitleViewModel
import com.example.taswaq.presentation.wishlist.WishlistViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TaswaqApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TaswaqApplication)
            modules(dataModule, networkModule)
        }
    }
}

val dataModule = module {
    //Home Page
    //single factory viewModel
    single { HomeRepository(get()) }
    viewModel { HomeViewModel(get()) }

    //See all featured or best seller
    single { SeeProductsOfTypeRepository() }
    viewModel { SeeProductsOfTitleViewModel(get(), get()) }

    //See all categories
    single { SeeAllCategoriesRepository(get()) }
    viewModel { SeeAllCategoriesViewModel(get()) }

    //Product details
    single { ProductDetailsRepository() }
    viewModel { params -> ProductDetailsViewModel(get(), params.get()) }

    //Sign in
    single { LogInRepository() }
    viewModel { LogInViewModel(get()) }

    //wishlist
    single { WishlistRepository() }
    viewModel { WishlistViewModel(get()) }

    //ordersList
    single { MyOrdersRepository() }
    viewModel { MyOrdersViewModel(get()) }

    //Cart
    single { CartRepository() }
    viewModel { CartViewModel(get()) }

    //CreateAddress
    single { CreateAddressRepository() }
    viewModel { CreateAddressViewModel(get()) }

    //Address
    single { AddressRepository() }
    viewModel { AddressViewModel(get()) }

    //payment
    single { PaymentRepository() }
    viewModel { PaymentViewModel(get()) }


}

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideTaswaqAPI(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideTaswaqAPI(retrofit: Retrofit): TaswaqAPI = retrofit.create(TaswaqAPI::class.java)
