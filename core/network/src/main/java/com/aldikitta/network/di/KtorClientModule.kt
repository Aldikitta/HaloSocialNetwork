package com.aldikitta.network.di

import com.aldikitta.network.ktor_client.auth.KtorClientAuthApi
import com.aldikitta.network.ktor_client.auth.KtorClientAuthApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object KtorClientModule {
    @Provides
    @Singleton
    fun getAuthApiImpl(authApiImpl: KtorClientAuthApiImpl): KtorClientAuthApi = authApiImpl
}