package com.aldikitta.hollahalo.presentation.login

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

    private val _usernameText = MutableStateFlow(LoginUiState(usernameText = ""))
    val usernameText = _usernameText.asStateFlow()

    private val _passwordText = MutableStateFlow(LoginUiState(passwordText = ""))
    val passwordText = _passwordText.asStateFlow()

    private var validatePassword = MutableStateFlow(true)

    private val _showPassword = MutableStateFlow(false)
    val showPassword = _showPassword.asStateFlow()

    private val _toggleVisibility = MutableStateFlow(false)
    val toggleVisibility = _toggleVisibility.asStateFlow()

//    fun validateForm(username: String, password: String) {
//        val passwordRegex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{8,}".toRegex()
//
//        validatePassword = passwordRegex.matches()
//    }

    fun showPassword(isVisible: Boolean = false) {

    }

    fun onEvent(loginUiEvent: LoginUiEvent) {
        when (loginUiEvent) {
            is LoginUiEvent.UsernameInputText -> {
                _usernameText.value = _loginUiState.value.copy(
                    usernameText = loginUiEvent.username
                )
            }
            is LoginUiEvent.PasswordInputText -> {
                _passwordText.value = _loginUiState.value.copy(
                    passwordText = loginUiEvent.password
                )
            }
            is LoginUiEvent.ShowSnackbar -> {

            }
            is LoginUiEvent.ClickLogin -> {

            }
            is LoginUiEvent.ValidateForm -> {

            }
            is LoginUiEvent.ToggleVisibility -> {
                _toggleVisibility.value = !_toggleVisibility.value
            }
            is LoginUiEvent.ShowPassword -> {
                if (_toggleVisibility.value) {
                    _showPassword.value
                } else {
                    _showPassword.value = true
                }
            }
        }
    }
}