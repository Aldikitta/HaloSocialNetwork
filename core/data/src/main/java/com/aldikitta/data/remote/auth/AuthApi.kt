package com.aldikitta.data.remote.auth

import com.aldikitta.data.dto.response.ApiResponse
import com.aldikitta.data.remote.auth.dto.request.SignInRequest
import com.aldikitta.data.remote.auth.dto.request.SignUpRequest
import com.aldikitta.data.remote.auth.dto.response.AuthResponse

interface AuthApi {
    suspend fun signUp(signUpRequest: SignUpRequest): ApiResponse<Unit>
    suspend fun signIn(signInRequest: SignInRequest): ApiResponse<AuthResponse>
}