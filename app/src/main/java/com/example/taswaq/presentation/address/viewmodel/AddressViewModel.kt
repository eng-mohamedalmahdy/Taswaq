package com.example.taswaq.presentation.address.viewmodel

import androidx.lifecycle.ViewModel
import com.example.taswaq.application.AddressRepository
import kotlinx.coroutines.flow.map

class AddressViewModel(private val repository:AddressRepository):ViewModel() {
    val getAddressList = repository.getAddressList().map { it.toList() }

}