package com.aldikitta.signin

import com.aldikitta.data.util.UiText

sealed class SignInUiEvent {
    data class UsernameInputText(val username: String) : SignInUiEvent()
    data class PasswordInputText(val password: String) : SignInUiEvent()
    data class ToggleVisibilityClick(val isToggleClick: Boolean) : SignInUiEvent()
    object EmptyFieldUsername : SignInUiEvent()
    object EmptyFieldPassword : SignInUiEvent()
    data class ValidateUsername(val username: String) : SignInUiEvent()
    data class ValidatePassword(val password: String) : SignInUiEvent()
    object SignIn : SignInUiEvent()
}

sealed class SignInEvent {
    data class ShowMessage(val uiText: UiText) : SignInEvent()
}