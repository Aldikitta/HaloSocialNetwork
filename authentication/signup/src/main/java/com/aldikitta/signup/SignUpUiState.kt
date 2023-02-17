package com.aldikitta.signup

import androidx.compose.runtime.Immutable
import com.aldikitta.data.dto.response.ApiResponse

sealed interface UIState {
    object Initial : UIState
    object Loading : UIState
    object Success : UIState
    data class Error(val error: String) : UIState
}
@Immutable
data class SignUpUiState(
    val emailText: String = "",
    val usernameText: String = "",
    val passwordText: String = "",
    val confirmPasswordText: String = "",
    val toggleVisibility: Boolean = false,
    val emptyField: String = "",

    val validateEmail: Boolean = true,
    val validateUsername: Boolean = true,
    val validatePassword: Boolean = true,
    val validateConfirmPassword: Boolean = true,
    val errorMessage: String = "",

    val isLoading: Boolean = false
)