package com.saveetha.e_commerceapplicationtask.Interface

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saveetha.e_commerceapplicationtask.Models.Product

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

    @Query("SELECT*FROM `Products`")
    fun getAll(): LiveData<List<Product>>
}