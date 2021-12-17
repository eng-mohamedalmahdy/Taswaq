package com.example.taswaq.application

import com.example.taswaq.domain.dummyAddressList
import com.example.taswaq.domain.model.DomainAddress

class CreateAddressRepository {

    fun addAddressList(domainAdress : DomainAddress){
         dummyAddressList.add(domainAdress)
    }
}