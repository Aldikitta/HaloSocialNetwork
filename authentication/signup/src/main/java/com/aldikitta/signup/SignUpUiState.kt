package com.aldikitta.signup

import androidx.compose.runtime.Immutable

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
)