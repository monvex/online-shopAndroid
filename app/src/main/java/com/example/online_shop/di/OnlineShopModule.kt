package com.example.online_shop.di

import com.example.online_shop.data.remote.OnlineShopApi
import com.example.online_shop.data.repository.OnlineShopRepositoryImpl
import com.example.online_shop.domain.repository.OnlineShopRepository
import com.example.online_shop.domain.use_cases.GetCategories
import com.example.online_shop.domain.use_cases.OnlineShopUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnlineShopModule {
    @Provides
    @Singleton
    fun provideOnlineShopRepository(api: OnlineShopApi): OnlineShopRepository {
        return OnlineShopRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideOnlineShopApi(): OnlineShopApi {
        return Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OnlineShopApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOnlineShopUseCases(repository: OnlineShopRepository): OnlineShopUseCases {
        return OnlineShopUseCases(
            getCategories = GetCategories(repository)
        )
    }
}