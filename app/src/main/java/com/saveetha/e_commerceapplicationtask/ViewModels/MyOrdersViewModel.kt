package com.saveetha.e_commerceapplicationtask.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saveetha.e_commerceapplicationtask.Models.AllProductsList
import com.saveetha.e_commerceapplicationtask.Models.Product
import com.saveetha.e_commerceapplicationtask.Repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyOrdersViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {

    val savedProducts: LiveData<List<Product>> = repository.observeAllProducts()

}