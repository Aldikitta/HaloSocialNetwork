package com.aldikitta.data.repository.auth

import com.aldikitta.data.dto.response.ApiResponse
import com.aldikitta.data.remote.auth.dto.request.SignUpRequest
import com.aldikitta.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signUp(signUpRequest: SignUpRequest) : Resource<Unit>
}