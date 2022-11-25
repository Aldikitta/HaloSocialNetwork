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
        }
    }
}