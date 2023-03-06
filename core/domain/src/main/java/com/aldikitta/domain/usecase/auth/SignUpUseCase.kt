package com.aldikitta.domain.usecase.auth

import com.aldikitta.auth.dto.request.SignUpRequest
import com.aldikitta.data.repository.auth.AuthRepository
import com.aldikitta.data.util.Resource
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(signUpRequest: SignUpRequest): Resource<Unit> {
        return authRepository.signUp(signUpRequest = signUpRequest)
    }
}