package com.saveetha.e_commerceapplicationtask.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saveetha.e_commerceapplicationtask.Models.AllProductsList
import com.saveetha.e_commerceapplicationtask.Interface.ApiService
import com.saveetha.e_commerceapplicationtask.Repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AllProductsViewModel @Inject constructor(private val repository: ProductRepository): ViewModel() {

    private val allProducts = MutableLiveData<List<AllProductsList>>()
    val products: LiveData<List<AllProductsList>> = repository.productsList

    private var currentPage = 0
    private var pageSize = 4
    private val allFetchedProducts = mutableListOf<AllProductsList>()

    fun fetchAllProducts() {
        repository.fetchAllProducts()
    }
}