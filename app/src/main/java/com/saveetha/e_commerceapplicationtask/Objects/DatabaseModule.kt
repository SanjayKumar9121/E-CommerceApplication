package com.saveetha.e_commerceapplicationtask.Objects

import android.content.Context
import androidx.room.Room
import com.saveetha.e_commerceapplicationtask.AppDatabase
import com.saveetha.e_commerceapplicationtask.Interface.ProductsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideProductsDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "products_database"
        ).build()
    }

    @Provides
    fun provideProductsDao(
        productsDatabase: AppDatabase
    ): ProductsDao {
        return productsDatabase.productDao()
    }
}