package com.saveetha.e_commerceapplicationtask

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.saveetha.e_commerceapplicationtask.Interface.ProductsDao
import com.saveetha.e_commerceapplicationtask.Models.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun productDao(): ProductsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}