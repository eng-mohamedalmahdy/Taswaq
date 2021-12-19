package com.example.taswaq.application

import com.example.taswaq.application.adapters.domainProfileToPresentationProfile
import com.example.taswaq.domain.dummyProfile
import com.example.taswaq.presentation.profile.model.PresentationProfile
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileRepository {

    val profileData: MutableStateFlow<PresentationProfile> = MutableStateFlow(
        domainProfileToPresentationProfile(dummyProfile)
    )
    val phoneNumber: MutableStateFlow<String> = MutableStateFlow(profileData.value.phoneNumber)
    fun updateProfile(password: String) {
        val updatedProfile = profileData.value.copy(phoneNumber = phoneNumber.value)

    }
}