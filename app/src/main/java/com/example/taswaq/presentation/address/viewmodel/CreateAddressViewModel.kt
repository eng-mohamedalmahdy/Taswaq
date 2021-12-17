package com.example.taswaq.presentation.address.viewmodel

import androidx.lifecycle.ViewModel
import com.example.taswaq.application.CreateAddressRepository
import com.example.taswaq.domain.model.DomainAddress

class CreateAddressViewModel(val repository: CreateAddressRepository) :ViewModel() {
    fun addAddress(city: String, street: String, lat: Double, lang: Double, notes: String) {
        val domainAddress = DomainAddress(city,street,lat,lang,notes)

        repository.addAddressList(domainAddress)
    }
}