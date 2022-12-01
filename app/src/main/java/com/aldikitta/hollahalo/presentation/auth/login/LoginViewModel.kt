package com.aldikitta.hollahalo.presentation.auth.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {
    private val _loginUiState = MutableStateFlow(LoginUiState())
    val loginUiState = _loginUiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<LoginUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(loginUiEvent: LoginUiEvent) {
        when (loginUiEvent) {
            is LoginUiEvent.UsernameInputText -> {
                _loginUiState.value = loginUiState.value.copy(
                    usernameText = loginUiEvent.username
                )
            }
            is LoginUiEvent.PasswordInputText -> {
                _loginUiState.value = loginUiState.value.copy(
                    passwordText = loginUiEvent.password
                )
            }
            is LoginUiEvent.EmptyFieldUsername -> {
                _loginUiState.value = loginUiState.value.copy(
                    usernameText = loginUiState.value.emptyField,
                )
            }
            is LoginUiEvent.EmptyFieldPassword -> {
                _loginUiState.value = loginUiState.value.copy(
                    passwordText = loginUiState.value.emptyField,
                )
            }
            is LoginUiEvent.ShowSnackbar -> {

            }
            is LoginUiEvent.ValidateUsername -> {
                val minUsernameLength = 3
                _loginUiState.value = loginUiState.value.copy(
                    validateUsername = loginUiState.value.usernameText.isNotBlank() && loginUiState.value.usernameText.length >= minUsernameLength,
                )
            }
            is LoginUiEvent.ValidatePassword -> {
                val passwordRegex =
                    "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{8,}".toRegex()
                _loginUiState.value = loginUiState.value.copy(
                    validatePassword = passwordRegex.matches(loginUiState.value.passwordText)
                )
            }
            is LoginUiEvent.ToggleVisibilityClick -> {
                _loginUiState.value = loginUiState.value.copy(
                    toggleVisibility = !loginUiState.value.toggleVisibility
                )
            }
        }
    }
}