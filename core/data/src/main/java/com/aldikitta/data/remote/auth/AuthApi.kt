package com.aldikitta.data.remote.auth

import com.aldikitta.data.dto.response.ApiResponse
import com.aldikitta.data.remote.auth.dto.request.SignUpRequest

interface AuthApi {
    suspend fun signUp(signUpRequest: SignUpRequest): ApiResponse<Unit>
}