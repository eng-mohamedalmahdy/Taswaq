package com.example.taswaq.application

import com.example.taswaq.domain.dummyVisaCardList
import com.example.taswaq.domain.model.DomainVisa
import kotlinx.coroutines.flow.flow

class PaymentRepository {

    fun addToVisaList(domainVisa: DomainVisa){
        dummyVisaCardList.add(domainVisa)
    }

    fun getVisaCardList() = flow{
        emit(dummyVisaCardList)
    }
}