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
                _loginUiState.value = loginUiState.value.copy(
                    usernameText = loginUiEvent.username
                )
            }
            is LoginUiEvent.PasswordInputText -> {
                _loginUiState.value = loginUiState.value.copy(
                    passwordText = loginUiEvent.password
                )
            }
            is LoginUiEvent.ShowSnackbar -> {

            }
            is LoginUiEvent.ClickLogin -> {

            }
            is LoginUiEvent.ValidateForm -> {

            }
            is LoginUiEvent.ToggleVisibilityClick -> {
                _loginUiState.value = loginUiState.value.copy(
                    toggleVisibility = !loginUiState.value.toggleVisibility
                )
            }
        }
    }
}