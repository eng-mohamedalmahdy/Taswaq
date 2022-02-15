package com.example.taswaq.domain.model

import com.google.gson.annotations.SerializedName

data class APIResponse<T>(
    @SerializedName("success") val success: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("data") val data: T
)
