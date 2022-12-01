package com.aldikitta.hollahalo.presentation.auth.register

import androidx.compose.runtime.Immutable

@Immutable
data class RegisterUiState(
    val emailText: String = "",
    val usernameText: String = "",
    val passwordText: String = "",
    val confirmPasswordText: String = "",
    val toggleVisibility: Boolean = false,
    val emptyField: String = "",

    val validateEmail: Boolean = true,
    val validateUsername: Boolean = true,
    val validatePassword: Boolean = true,
    val validateConfirmPassword: Boolean = true
    )