package com.aldikitta.domain.di

import com.aldikitta.domain.usecase.auth.SignUpUseCase
import com.aldikitta.domain.usecase.auth.SignUpUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun getSignUpUseCaseImpl(authUseCaseImpl: SignUpUseCaseImpl): SignUpUseCase = authUseCaseImpl
}