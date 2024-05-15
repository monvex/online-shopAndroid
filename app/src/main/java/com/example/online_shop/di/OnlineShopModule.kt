package com.example.online_shop.di

import com.example.online_shop.data.remote.OnlineShopApi
import com.example.online_shop.data.repository.OnlineShopRepositoryImpl
import com.example.online_shop.domain.repository.OnlineShopRepository
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
            .baseUrl("http://192.168.0.102:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OnlineShopApi::class.java)
    }

}