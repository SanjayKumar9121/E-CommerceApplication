package com.saveetha.e_commerceapplicationtask.Interface

import com.saveetha.e_commerceapplicationtask.Models.AllProductsList
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    fun getAllProducts(): retrofit2.Call<List<AllProductsList>>
}