package com.example.taswaq.application

import com.example.taswaq.domain.dummyAddressList
import kotlinx.coroutines.flow.flow

class AddressRepository {

    fun getAddressList() = flow { emit(dummyAddressList) }

}