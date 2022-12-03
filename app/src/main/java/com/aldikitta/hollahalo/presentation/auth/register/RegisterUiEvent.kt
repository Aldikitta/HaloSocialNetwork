package com.aldikitta.hollahalo.presentation.auth.register

import com.aldikitta.hollahalo.presentation.auth.login.LoginUiEvent

sealed class RegisterUiEvent {
    data class EmailInputText(val email: String) : RegisterUiEvent()
    data class UsernameInputText(val username: String) : RegisterUiEvent()
    data class PasswordInputText(val password: String) : RegisterUiEvent()
    data class ConfirmPasswordInputText(val confirmPassword: String) : RegisterUiEvent()
    data class ToggleVisibilityClick(val isToggleClick: Boolean) : RegisterUiEvent()
    object EmptyFieldEmail : RegisterUiEvent()
    object EmptyFieldUsername : RegisterUiEvent()
    object EmptyFieldPassword : RegisterUiEvent()
    object EmptyFieldConfirmPassword : RegisterUiEvent()
    data class ValidateEmail(val email: String): RegisterUiEvent()
    data class ValidateUsername(val username: String): RegisterUiEvent()
    data class ValidatePassword(val password: String): RegisterUiEvent()
    data class ValidateConfirmPassword(val confirmPassword: String): RegisterUiEvent()
    data class ValidateForm(
        val email: String,
        val username: String,
        val password: String,
        val confirmPassword: String
    ) : RegisterUiEvent()

//    data class ShowSnackbar(val message: String): RegisterUiEvent()
//    object ClickRegister: RegisterUiEvent()

}