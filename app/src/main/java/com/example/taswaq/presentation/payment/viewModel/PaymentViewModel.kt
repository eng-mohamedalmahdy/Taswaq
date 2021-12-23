package com.example.taswaq.presentation.payment.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.taswaq.application.CartRepository
import com.example.taswaq.application.PaymentRepository
import com.example.taswaq.domain.model.DomainVisa
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PaymentViewModel(val repository:PaymentRepository): ViewModel() {
     fun addToVisaCrdList(domainVisa: DomainVisa) {
        repository.addToVisaList(domainVisa)
     }

    fun getSubTotalPrice(): Flow<Int> = repository.getCartItemsPrice()

    fun getVisaCardList() = repository.getVisaCardList().also { Log.d("TAG", "getVisaCardList: $it") }.map { it.toList() }

}