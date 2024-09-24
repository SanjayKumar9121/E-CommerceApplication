package com.saveetha.e_commerceapplicationtask.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int? = 0,
    val name: String,
    val description: String,
    val image: String,
    val price: Int
)
