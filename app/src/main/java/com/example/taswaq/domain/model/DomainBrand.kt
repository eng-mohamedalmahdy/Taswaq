package com.example.taswaq.domain.model

import com.google.gson.annotations.SerializedName

data class DomainBrands(val brands: List<DomainBrand>)
data class DomainBrand(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("color") var color: String? = null
)
