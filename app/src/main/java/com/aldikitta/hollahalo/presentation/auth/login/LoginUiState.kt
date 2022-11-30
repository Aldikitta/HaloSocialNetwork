package com.aldikitta.hollahalo.presentation.auth.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginUiState(
    val usernameText: String = "",
    val passwordText: String = "",
    val toggleVisibility: Boolean = false,
    val validateUsername: Boolean = true,
    val validatePassword: Boolean = true,
    val emptyField: String = "",

    val validateForm: Boolean = false,

)