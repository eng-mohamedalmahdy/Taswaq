package com.example.taswaq.presentation.myorders

import androidx.lifecycle.ViewModel
import com.example.taswaq.application.MyOrdersRepository
import com.example.taswaq.presentation.myorders.model.Order
import kotlinx.coroutines.flow.MutableStateFlow

class MyOrdersViewModel(private val repository: MyOrdersRepository) : ViewModel() {
    fun getOrdersHistory() : MutableStateFlow<List<Order>> = repository.getOrdersHistory()
}