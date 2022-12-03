package com.aldikitta.hollahalo.presentation.auth.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(

) : ViewModel() {
    private val _registerUiState = MutableStateFlow(RegisterUiState())
    val registerUiState = _registerUiState.asStateFlow()

    fun onEvent(registerUiEvent: RegisterUiEvent) {
        when (registerUiEvent) {
            is RegisterUiEvent.EmailInputText -> {
                _registerUiState.value = registerUiState.value.copy(
                    emailText = registerUiEvent.email
                )
            }
            is RegisterUiEvent.UsernameInputText -> {
                _registerUiState.value = registerUiState.value.copy(
                    usernameText = registerUiEvent.username
                )
            }
            is RegisterUiEvent.PasswordInputText -> {
                _registerUiState.value = registerUiState.value.copy(
                    passwordText = registerUiEvent.password
                )
            }
            is RegisterUiEvent.ConfirmPasswordInputText -> {
                _registerUiState.value = registerUiState.value.copy(
                    confirmPasswordText = registerUiEvent.confirmPassword
                )
            }
            is RegisterUiEvent.EmptyFieldEmail -> {
                _registerUiState.value = registerUiState.value.copy(
                    emailText = registerUiState.value.emptyField
                )
            }
            is RegisterUiEvent.EmptyFieldUsername -> {
                _registerUiState.value = registerUiState.value.copy(
                    usernameText = registerUiState.value.emptyField
                )
            }
            is RegisterUiEvent.EmptyFieldPassword -> {
                _registerUiState.value = registerUiState.value.copy(
                    passwordText = registerUiState.value.emptyField
                )
            }
            is RegisterUiEvent.EmptyFieldConfirmPassword -> {
                _registerUiState.value = registerUiState.value.copy(
                    confirmPasswordText = registerUiState.value.emptyField
                )
            }
            is RegisterUiEvent.ToggleVisibilityClick -> {
                _registerUiState.value = registerUiState.value.copy(
                    toggleVisibility = !registerUiState.value.toggleVisibility
                )
            }
            is RegisterUiEvent.ValidateEmail -> {
                _registerUiState.value = registerUiState.value.copy(
                    validateEmail = Patterns.EMAIL_ADDRESS.matcher(registerUiState.value.emailText)
                        .matches(),
                )
            }
            is RegisterUiEvent.ValidateUsername -> {
                val minUsernameLength = 3
                _registerUiState.value = registerUiState.value.copy(
                    validateUsername = registerUiState.value.usernameText.isNotBlank() && registerUiState.value.usernameText.length >= minUsernameLength,
                )
            }
            is RegisterUiEvent.ValidatePassword -> {
                val passwordRegex =
                    "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{8,}".toRegex()
                _registerUiState.value = registerUiState.value.copy(
                    validatePassword = passwordRegex.matches(registerUiState.value.passwordText)
                )
            }
            is RegisterUiEvent.ValidateConfirmPassword -> {
                _registerUiState.value = registerUiState.value.copy(
                    validateConfirmPassword = registerUiState.value.passwordText == registerUiState.value.confirmPasswordText
                )
            }

            is RegisterUiEvent.ValidateForm -> {
                val passwordRegex =
                    "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{8,}".toRegex()
                _registerUiState.value = registerUiState.value.copy(
                    validateEmail = Patterns.EMAIL_ADDRESS.matcher(registerUiState.value.emailText)
                        .matches(),
                    validateUsername = registerUiState.value.usernameText.isNotBlank(),
                    validatePassword = passwordRegex.matches(registerUiState.value.passwordText),
                    validateConfirmPassword = registerUiState.value.confirmPasswordText == registerUiState.value.passwordText
                )
            }
        }
    }
}