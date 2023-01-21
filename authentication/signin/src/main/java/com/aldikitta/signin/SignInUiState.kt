package com.aldikitta.signin

import androidx.compose.runtime.Immutable

@Immutable
data class SignInUiState(
    val usernameText: String = "",
    val passwordText: String = "",
    val toggleVisibility: Boolean = false,
    val emptyField: String = "",

    val validateUsername: Boolean = true,
    val validatePassword: Boolean = true
)