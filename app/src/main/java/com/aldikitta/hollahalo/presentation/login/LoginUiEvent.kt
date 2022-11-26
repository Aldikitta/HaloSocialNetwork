package com.aldikitta.hollahalo.presentation.login

sealed class LoginUiEvent {
    data class UsernameInputText(val username: String): LoginUiEvent()
    data class PasswordInputText(val password: String): LoginUiEvent()
    data class ShowSnackbar(val message: String): LoginUiEvent()
    data class ValidateForm(val username: String, val password: String): LoginUiEvent()
    object ShowPassword: LoginUiEvent()
    data class ToggleVisibility(val isToggle: Boolean): LoginUiEvent()
    object ClickLogin: LoginUiEvent()
}