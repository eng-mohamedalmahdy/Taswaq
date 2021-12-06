package com.example.taswaq.application

import com.example.taswaq.domain.dummyOrders
import kotlinx.coroutines.flow.MutableStateFlow

class MyOrdersRepository {
    fun getOrdersHistory() = MutableStateFlow(dummyOrders)
}