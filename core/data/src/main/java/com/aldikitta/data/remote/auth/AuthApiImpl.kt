package com.aldikitta.data.remote.auth

import com.aldikitta.data.dto.response.ApiResponse
import com.aldikitta.data.remote.auth.dto.request.SignUpRequest
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class AuthApiImpl @Inject constructor(
    private val httpClient: HttpClient
) : AuthApi {
    override suspend fun signUp(signUpRequest: SignUpRequest): ApiResponse<Unit> {
        return httpClient.post("/api/user/creat") {
            setBody(signUpRequest)
        }.body()
    }
}