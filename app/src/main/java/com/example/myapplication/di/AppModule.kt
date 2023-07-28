package com.example.myapplication.di

import com.example.graphqlmsn.common.Constants
import com.example.myapplication.domain.data.MsnApi
import com.example.myapplication.domain.repository.MsnRepository
import com.example.myapplication.domain.repository.MsnRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMsnApi(): MsnApi {
        return Retrofit.Builder()
            .baseUrl(Constants.Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build())
            .build()
            .create(MsnApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMsnApiRepository(api: MsnApi): MsnRepository {
        return MsnRepositoryImp(api)
    }
}