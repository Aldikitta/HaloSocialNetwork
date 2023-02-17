package com.aldikitta.signup

import com.aldikitta.data.util.UiText

sealed class SignUpUiEvent {
    data class EmailInputText(val email: String) : SignUpUiEvent()
    data class UsernameInputText(val username: String) : SignUpUiEvent()
    data class PasswordInputText(val password: String) : SignUpUiEvent()
    data class ConfirmPasswordInputText(val confirmPassword: String) : SignUpUiEvent()
    data class ToggleVisibilityClick(val isToggleClick: Boolean) : SignUpUiEvent()
    object EmptyFieldEmail : SignUpUiEvent()
    object EmptyFieldUsername : SignUpUiEvent()
    object EmptyFieldPassword : SignUpUiEvent()
    object EmptyFieldConfirmPassword : SignUpUiEvent()
    data class ValidateEmail(val email: String): SignUpUiEvent()
    data class ValidateUsername(val username: String): SignUpUiEvent()
    data class ValidatePassword(val password: String): SignUpUiEvent()
    data class ValidateConfirmPassword(val confirmPassword: String): SignUpUiEvent()
    data class ValidateForm(
        val email: String,
        val username: String,
        val password: String,
        val confirmPassword: String
    ) : SignUpUiEvent()
    object SignUp : SignUpUiEvent()
}

sealed class SignUpEvent{
    data class ShowMessage(val uiText: UiText): SignUpEvent()
}