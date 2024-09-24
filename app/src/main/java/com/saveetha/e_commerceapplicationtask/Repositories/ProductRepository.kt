package com.saveetha.e_commerceapplicationtask.Repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.saveetha.e_commerceapplicationtask.Interface.ApiService
import com.saveetha.e_commerceapplicationtask.Interface.ProductsDao
import com.saveetha.e_commerceapplicationtask.Models.AllProductsList
import com.saveetha.e_commerceapplicationtask.Models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiService: ApiService,
                                            private val productDao: ProductsDao
) {
    private val allProducts = MutableLiveData<List<AllProductsList>>()
    val productsList: LiveData<List<AllProductsList>> = allProducts

    fun fetchAllProducts() {
        apiService.getAllProducts().enqueue(object : Callback<List<AllProductsList>> {
            override fun onResponse(
                call: Call<List<AllProductsList>>,
                response: Response<List<AllProductsList>>
            ) {
                if (response.isSuccessful) {
                    allProducts.value = response.body()
                    println(allProducts.value)
                } else {
                    Log.e("TAG", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<AllProductsList>>, t: Throwable) {
                Log.e("TAG", "Error fetching transport bus pass: $t")
            }

        })
    }


     suspend fun insertProduct(product: Product) {
        withContext(Dispatchers.IO) {
            productDao.insert(product)
        }
    }

    fun observeAllProducts(): LiveData<List<Product>> {
        return productDao.getAll()
    }

}