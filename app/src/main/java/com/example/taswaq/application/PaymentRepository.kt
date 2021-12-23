package com.example.taswaq.application

import android.util.Log
import com.example.taswaq.domain.dummyVisaCardList
import com.example.taswaq.domain.model.DomainCart
import com.example.taswaq.domain.model.DomainVisa
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PaymentRepository {

    fun addToVisaList(domainVisa: DomainVisa) {
        dummyVisaCardList.add(domainVisa)
    }

    fun getVisaCardList() = flow {
        emit(dummyVisaCardList).also {
            Log.d("TAG", "getVisaCardList: emitted ")
        }
    }

    fun getCartItemsPrice(): Flow<Int> = DomainCart.cartItemsPrice
}