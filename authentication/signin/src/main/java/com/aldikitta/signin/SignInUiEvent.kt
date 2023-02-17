package com.aldikitta.signin

sealed class SignInUiEvent {
    data class UsernameInputText(val username: String): SignInUiEvent()
    data class PasswordInputText(val password: String): SignInUiEvent()
    data class ToggleVisibilityClick(val isToggleClick: Boolean): SignInUiEvent()
    object EmptyFieldUsername: SignInUiEvent()
    object EmptyFieldPassword: SignInUiEvent()
    data class ValidateUsername(val username: String): SignInUiEvent()
    data class ValidatePassword(val password: String): SignInUiEvent()

    data class ShowSnackbar(val message: String): SignInUiEvent()


}