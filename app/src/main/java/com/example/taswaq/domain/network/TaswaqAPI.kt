package com.example.taswaq.domain.network

import com.example.taswaq.domain.model.*
import retrofit2.http.GET

interface TaswaqAPI {

    @GET("brands")
    suspend fun getAllBrands(): APIResponse<DomainBrands>

    @GET("categories")
    suspend fun getAllCategories(): APIResponse<DomainCategories>

    @GET("subcategories/{{id}}")
    suspend fun getSubCategoriesOfCategory(categoryId: Int): APIResponse<DomainSubCategories>
}