package com.aldikitta.hollahalo.presentation.login

sealed class LoginUiEvent {
    data class UsernameInputText(val username: String): LoginUiEvent()
    data class PasswordInputText(val password: String): LoginUiEvent()
    data class ShowSnackbar(val message: String): LoginUiEvent()
    object ClickLogin: LoginUiEvent()
}