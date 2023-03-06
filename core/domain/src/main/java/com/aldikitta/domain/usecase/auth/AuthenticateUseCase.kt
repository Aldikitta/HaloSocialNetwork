package com.aldikitta.domain.usecase.auth

import com.aldikitta.data.repository.auth.AuthRepository
import com.aldikitta.data.util.Resource

class AuthenticateUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() : Resource<Unit> {
        return authRepository.authenticate()
    }
}