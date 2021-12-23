package com.example.taswaq.presentation.payment.viewModel

import androidx.lifecycle.ViewModel
import com.example.taswaq.application.CartRepository
import com.example.taswaq.application.PaymentRepository
import com.example.taswaq.domain.model.DomainVisa
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PaymentViewModel(val repository:PaymentRepository): ViewModel() {
     fun addToVisaCrdList(visaNumber:String,visaUserName:String,
                          visaDay:String,visaMonth:String,visaYear:String){
         val domainVisa= DomainVisa(visaNumber,visaDay,visaMonth,visaYear,visaUserName)

        repository.addToVisaList(domainVisa)

     }
    val cartRepo = CartRepository()

    fun getSubTotalPrice(): Flow<Int> = cartRepo.getCartItemsPrice()

    fun getVisaCardList() = repository.getVisaCardList().map { it.toList() }

}