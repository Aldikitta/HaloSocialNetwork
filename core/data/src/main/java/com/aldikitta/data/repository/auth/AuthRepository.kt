package com.aldikitta.data.repository.auth

import com.aldikitta.auth.dto.request.SignInRequest
import com.aldikitta.auth.dto.request.SignUpRequest
import com.aldikitta.data.util.Resource

interface AuthRepository {
    suspend fun signUp(signUpRequest: SignUpRequest) : Resource<Unit>
    suspend fun signIn(signInRequest: SignInRequest) : Resource<Unit>
    suspend fun authenticate() : Resource<Unit>
}