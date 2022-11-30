package com.aldikitta.hollahalo.presentation.auth.login

sealed class LoginUiEvent {
    data class UsernameInputText(val username: String): LoginUiEvent()
    data class PasswordInputText(val password: String): LoginUiEvent()
    data class ToggleVisibilityClick(val isToggleClick: Boolean): LoginUiEvent()
    object EmptyFieldUsername: LoginUiEvent()
    object EmptyFieldPassword: LoginUiEvent()

    data class ValidateForm(val username: String, val password: String): LoginUiEvent()
    data class ShowSnackbar(val message: String): LoginUiEvent()
    object ClickLogin: LoginUiEvent()

}