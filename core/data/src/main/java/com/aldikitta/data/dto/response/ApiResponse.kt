package com.aldikitta.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val successful: Boolean,
    val message: String? = null,
    val data: T? = null
)