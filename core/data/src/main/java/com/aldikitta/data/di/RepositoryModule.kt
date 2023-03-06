package com.aldikitta.data.di

import com.aldikitta.data.repository.auth.AuthRepository
import com.aldikitta.data.repository.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun getAuthRepositoryImpl(authRepositoryImpl: AuthRepositoryImpl): AuthRepository = authRepositoryImpl
}