package com.aldikitta.network.retrofit.auth

import com.aldikitta.auth.dto.request.SignInRequest
import com.aldikitta.auth.dto.request.SignUpRequest
import com.aldikitta.auth.dto.response.AuthResponse
import com.aldikitta.dto.response.ApiResponse

interface RetrofitAuthApi {
    suspend fun signUp(signUpRequest: SignUpRequest): ApiResponse<Unit>
    suspend fun signIn(signInRequest: SignInRequest): ApiResponse<AuthResponse>
    suspend fun authenticate()
}