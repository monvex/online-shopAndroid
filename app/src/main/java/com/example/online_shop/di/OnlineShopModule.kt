package com.example.online_shop.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.online_shop.data.dataStore.TokenManager
import com.example.online_shop.data.remote.OnlineShopApi
import com.example.online_shop.data.repository.OnlineShopRepositoryImpl
import com.example.online_shop.domain.repository.OnlineShopRepository
import com.example.online_shop.presentation.auth.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "data_store")

@Module
@InstallIn(SingletonComponent::class)
object OnlineShopModule {
    @Provides
    @Singleton
    fun provideOnlineShopRepository(
        api: OnlineShopApi ,
        tokenManager: TokenManager
    ): OnlineShopRepository {
        return OnlineShopRepositoryImpl(api , tokenManager)
    }

    @Provides
    @Singleton
    fun provideOnlineShopApi(): OnlineShopApi {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.104:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OnlineShopApi::class.java)
    }
    @Singleton
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager = TokenManager(context)


}

