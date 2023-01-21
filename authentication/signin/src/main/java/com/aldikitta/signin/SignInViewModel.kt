package com.aldikitta.signin

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(

) : ViewModel() {
    private val _signInUiState = MutableStateFlow(SignInUiState())
    val signInUiState = _signInUiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<SignInUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(signInUiEvent: SignInUiEvent) {
        when (signInUiEvent) {
            //TODO check weather we need to use _signInUiState or signInUiState (probably use the private one)
            is SignInUiEvent.UsernameInputText -> {
                _signInUiState.value = signInUiState.value.copy(
                    usernameText = signInUiEvent.username
                )
            }
            is SignInUiEvent.PasswordInputText -> {
                _signInUiState.value = signInUiState.value.copy(
                    passwordText = signInUiEvent.password
                )
            }
            is SignInUiEvent.EmptyFieldUsername -> {
                _signInUiState.value = signInUiState.value.copy(
                    usernameText = signInUiState.value.emptyField,
                )
            }
            is SignInUiEvent.EmptyFieldPassword -> {
                _signInUiState.value = signInUiState.value.copy(
                    passwordText = signInUiState.value.emptyField,
                )
            }
            is SignInUiEvent.ShowSnackbar -> {

            }
            is SignInUiEvent.ValidateUsername -> {
                val minUsernameLength = 3
                _signInUiState.value = signInUiState.value.copy(
                    validateUsername = signInUiState.value.usernameText.isNotBlank() && signInUiState.value.usernameText.length >= minUsernameLength,
                )
            }
            is SignInUiEvent.ValidatePassword -> {
                val passwordRegex =
                    "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{8,}".toRegex()
                _signInUiState.value = signInUiState.value.copy(
                    validatePassword = passwordRegex.matches(signInUiState.value.passwordText)
                )
            }
            is SignInUiEvent.ToggleVisibilityClick -> {
                _signInUiState.value = signInUiState.value.copy(
                    toggleVisibility = !signInUiState.value.toggleVisibility
                )
            }
        }
    }
}