package com.aldikitta.signup

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

) : ViewModel() {
    private val _signUpUiState = MutableStateFlow(SignUpUiState())
    val registerUiState = _signUpUiState.asStateFlow()

    fun onEvent(signUpUiEvent: SignUpUiEvent) {
        when (signUpUiEvent) {
            is SignUpUiEvent.EmailInputText -> {
                _signUpUiState.value = registerUiState.value.copy(
                    emailText = signUpUiEvent.email
                )
            }
            is SignUpUiEvent.UsernameInputText -> {
                _signUpUiState.value = registerUiState.value.copy(
                    usernameText = signUpUiEvent.username
                )
            }
            is SignUpUiEvent.PasswordInputText -> {
                _signUpUiState.value = registerUiState.value.copy(
                    passwordText = signUpUiEvent.password
                )
            }
            is SignUpUiEvent.ConfirmPasswordInputText -> {
                _signUpUiState.value = registerUiState.value.copy(
                    confirmPasswordText = signUpUiEvent.confirmPassword
                )
            }
            is SignUpUiEvent.EmptyFieldEmail -> {
                _signUpUiState.value = registerUiState.value.copy(
                    emailText = registerUiState.value.emptyField
                )
            }
            is SignUpUiEvent.EmptyFieldUsername -> {
                _signUpUiState.value = registerUiState.value.copy(
                    usernameText = registerUiState.value.emptyField
                )
            }
            is SignUpUiEvent.EmptyFieldPassword -> {
                _signUpUiState.value = registerUiState.value.copy(
                    passwordText = registerUiState.value.emptyField
                )
            }
            is SignUpUiEvent.EmptyFieldConfirmPassword -> {
                _signUpUiState.value = registerUiState.value.copy(
                    confirmPasswordText = registerUiState.value.emptyField
                )
            }
            is SignUpUiEvent.ToggleVisibilityClick -> {
                _signUpUiState.value = registerUiState.value.copy(
                    toggleVisibility = !registerUiState.value.toggleVisibility
                )
            }
            is SignUpUiEvent.ValidateEmail -> {
                _signUpUiState.value = registerUiState.value.copy(
                    validateEmail = Patterns.EMAIL_ADDRESS.matcher(registerUiState.value.emailText)
                        .matches(),
                )
            }
            is SignUpUiEvent.ValidateUsername -> {
                val minUsernameLength = 3
                _signUpUiState.value = registerUiState.value.copy(
                    validateUsername = registerUiState.value.usernameText.isNotBlank() && registerUiState.value.usernameText.length >= minUsernameLength,
                )
            }
            is SignUpUiEvent.ValidatePassword -> {
                val passwordRegex =
                    "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{8,}".toRegex()
                _signUpUiState.value = registerUiState.value.copy(
                    validatePassword = passwordRegex.matches(registerUiState.value.passwordText)
                )
            }
            is SignUpUiEvent.ValidateConfirmPassword -> {
                _signUpUiState.value = registerUiState.value.copy(
                    validateConfirmPassword = registerUiState.value.passwordText == registerUiState.value.confirmPasswordText
                )
            }

            is SignUpUiEvent.ValidateForm -> {
                val passwordRegex =
                    "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{8,}".toRegex()
                _signUpUiState.value = registerUiState.value.copy(
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