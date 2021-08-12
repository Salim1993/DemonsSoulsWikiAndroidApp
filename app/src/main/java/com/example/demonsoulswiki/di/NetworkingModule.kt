package com.example.demonsoulswiki.di

import com.example.demonsoulswiki.networking.DarkSoulsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkingModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(URL).addConverterFactory(MoshiConverterFactory.create()).build()
    }

    @Provides
    fun getDarkSoulsApiService(retrofit: Retrofit): DarkSoulsApiService {
        return retrofit.create(DarkSoulsApiService::class.java)
    }

    private const val URL = ""
}