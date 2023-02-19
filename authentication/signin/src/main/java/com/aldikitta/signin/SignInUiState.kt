package com.aldikitta.signin

import androidx.compose.runtime.Immutable

sealed interface UIState {
    object Loading : UIState
    object Success : UIState
    data class Error(val error: String) : UIState
}
@Immutable
data class SignInUiState(
    val usernameText: String = "",
    val passwordText: String = "",
    val toggleVisibility: Boolean = false,
    val emptyField: String = "",

    val validateUsername: Boolean = true,
    val validatePassword: Boolean = true,

    val isLoading: Boolean = false
)