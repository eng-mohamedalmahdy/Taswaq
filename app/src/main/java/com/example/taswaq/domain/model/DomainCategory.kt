package com.example.taswaq.domain.model

import com.google.gson.annotations.SerializedName

data class DomainCategories(val categories: List<DomainCategory>)
data class DomainCategory(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("piority") var piority: Int? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("color") var color: String? = null,
    @SerializedName("description") var description: String? = null
)
