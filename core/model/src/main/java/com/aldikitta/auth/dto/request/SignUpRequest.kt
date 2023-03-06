package com.aldikitta.auth.dto.request

data class SignUpRequest(
    val email: String,
    val username: String,
    val password: String
)
