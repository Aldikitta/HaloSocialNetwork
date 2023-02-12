package com.aldikitta.domain.usecase.auth

import com.aldikitta.data.dto.response.ApiResponse
import com.aldikitta.data.remote.auth.dto.request.SignUpRequest
import com.aldikitta.data.repository.auth.AuthRepository
import com.aldikitta.data.util.Resource
import com.aldikitta.data.util.UiText
import com.aldikitta.data.R
import io.ktor.client.plugins.*
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : SignUpUseCase {
    override fun invoke(signUpRequest: SignUpRequest): Flow<Resource<ApiResponse<Unit>>> {
        TODO("Not yet implemented")
    }
}