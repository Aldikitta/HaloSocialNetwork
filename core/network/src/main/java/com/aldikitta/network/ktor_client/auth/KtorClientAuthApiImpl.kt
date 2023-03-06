package com.aldikitta.network.ktor_client.auth

import com.aldikitta.auth.dto.request.SignInRequest
import com.aldikitta.auth.dto.request.SignUpRequest
import com.aldikitta.auth.dto.response.AuthResponse
import com.aldikitta.dto.response.ApiResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class KtorClientAuthApiImpl @Inject constructor(
    private val httpClient: HttpClient
) : KtorClientAuthApi {
    override suspend fun signUp(signUpRequest: SignUpRequest): ApiResponse<Unit> {
        return httpClient.post("/api/user/create") {
            setBody(signUpRequest)
        }.body()
    }

    override suspend fun signIn(signInRequest: SignInRequest): ApiResponse<AuthResponse> {
        return httpClient.post("/api/user/login") {
            setBody(signInRequest)
        }.body()
    }

    override suspend fun authenticate() {
        return httpClient.get("/api/user/aue").body()
    }
}