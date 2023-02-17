package com.aldikitta.domain.usecase.auth

import com.aldikitta.data.dto.response.ApiResponse
import com.aldikitta.data.remote.auth.dto.request.SignUpRequest
import com.aldikitta.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface SignUpUseCase {
    operator fun invoke(signUpRequest: SignUpRequest): Flow<Resource<ApiResponse<Unit>>>
}