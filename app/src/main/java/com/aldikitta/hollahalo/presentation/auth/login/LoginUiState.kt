package com.aldikitta.hollahalo.presentation.auth.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginUiState(
    val usernameText: String = "",
    val passwordText: String = "",
    val toggleVisibility: Boolean = false,
    val emptyField: String = "",

    val validateUsername: Boolean = true,
    val validatePassword: Boolean = true
)