package com.aldikitta.dto.response

data class ApiResponse<T>(
    val successful: Boolean,
    val message: String? = null,
    val data: T? = null
)