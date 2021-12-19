package com.example.taswaq.presentation.profile.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taswaq.application.ProfileRepository
import com.example.taswaq.presentation.profile.model.PresentationProfile
import kotlinx.coroutines.flow.*

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {

    private val currentProfileData: MutableStateFlow<PresentationProfile> =
        repository.profileData

    private var oldProfileData: PresentationProfile = currentProfileData.value.copy()


    val firstName: StateFlow<String> = currentProfileData.map { it.firstName }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        currentProfileData.value.firstName
    )

    val lastName: StateFlow<String> = currentProfileData.map { it.lastName }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        currentProfileData.value.lastName
    )

    val email: StateFlow<String> = currentProfileData.map { it.lastName }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        currentProfileData.value.email
    )

    val phoneNumber: MutableStateFlow<String> = repository.phoneNumber


    fun profileDataChanged(): Boolean = currentProfileData.value == oldProfileData

    val updateProfile = repository::updateProfile


}