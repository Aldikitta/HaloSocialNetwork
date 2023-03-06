package com.aldikitta.domain.usecase.auth

import com.aldikitta.auth.dto.request.SignInRequest
import com.aldikitta.data.repository.auth.AuthRepository
import com.aldikitta.data.util.Resource
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(signInRequest: SignInRequest): Resource<Unit> {
        return authRepository.signIn(signInRequest = signInRequest)
    }
}