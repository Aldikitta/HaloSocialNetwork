package com.aldikitta.hollahalo.presentation.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginUiState(
    val usernameText: String = "",
    val passwordText: String = "",
    val toggleVisibility: Boolean = false,

    val validateForm: Boolean = false,

)