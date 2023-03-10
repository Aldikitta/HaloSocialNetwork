package com.aldikitta.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldikitta.auth.dto.request.SignInRequest
import com.aldikitta.data.util.Resource
import com.aldikitta.data.util.UiText
import com.aldikitta.domain.usecase.auth.AuthenticateUseCase
import com.aldikitta.domain.usecase.auth.SignInUseCase
import com.aldikitta.designsystem.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val authenticateUseCase: AuthenticateUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UIStateSignIn> = MutableStateFlow(UIStateSignIn.Initial)
    val uiState: StateFlow<UIStateSignIn> = _uiState.asStateFlow()

    private val _signInUiState = MutableStateFlow(SignInUiState())
    val signInUiState = _signInUiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<SignInEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(signInUiEvent: SignInUiEvent) {
        when (signInUiEvent) {
            is SignInUiEvent.UsernameInputText -> {
                _signInUiState.value = _signInUiState.value.copy(
                    usernameText = signInUiEvent.username.trim()
                )
            }
            is SignInUiEvent.PasswordInputText -> {
                _signInUiState.value = _signInUiState.value.copy(
                    passwordText = signInUiEvent.password.trim()
                )
            }
            is SignInUiEvent.EmptyFieldUsername -> {
                _signInUiState.value = _signInUiState.value.copy(
                    usernameText = _signInUiState.value.emptyField,
                )
            }
            is SignInUiEvent.EmptyFieldPassword -> {
                _signInUiState.value = _signInUiState.value.copy(
                    passwordText = _signInUiState.value.emptyField,
                )
            }
            is SignInUiEvent.ValidateUsername -> {
                val minUsernameLength = 3
                _signInUiState.value = _signInUiState.value.copy(
                    validateUsername = _signInUiState.value.usernameText.isNotBlank() && _signInUiState.value.usernameText.length >= minUsernameLength,
                )
            }
            is SignInUiEvent.ValidatePassword -> {
                val passwordRegex =
                    "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{8,}".toRegex()
                _signInUiState.value = _signInUiState.value.copy(
                    validatePassword = passwordRegex.matches(_signInUiState.value.passwordText)
                )
            }
            is SignInUiEvent.ToggleVisibilityClick -> {
                _signInUiState.value = _signInUiState.value.copy(
                    toggleVisibility = !_signInUiState.value.toggleVisibility
                )
            }
            is SignInUiEvent.SignIn -> {
                viewModelScope.launch {
                    _signInUiState.value = _signInUiState.value.copy(
                        isLoading = true
                    )
                    signInUseCase(
                        signInRequest = SignInRequest(
                            email = signInUiState.value.usernameText,
                            password = signInUiState.value.passwordText

                        )
                    ).let {
                        Log.d("SignIn", signInUiState.value.usernameText)
                        Log.d("SignIn", signInUiState.value.passwordText)

                        when (it) {
                            is Resource.Success -> {
                                _eventFlow.emit(
                                    SignInEvent.ShowMessage(UiText.StringResource(R.string.successfully_signin))
                                )
                                _uiState.value = UIStateSignIn.Success
                                _signInUiState.value = _signInUiState.value.copy(
                                    isLoading = false
                                )
                            }
                            is Resource.Loading -> {
                                _uiState.value = UIStateSignIn.Initial
                                _signInUiState.value = _signInUiState.value.copy(
                                    isLoading = true
                                )
                            }
                            is Resource.Error -> {
                                _eventFlow.emit(
                                    SignInEvent.ShowMessage(
                                        uiText = it.uiText ?: UiText.unknownError()
                                    )
                                )
                                _uiState.value =
                                    UIStateSignIn.Error(error = it.exception.toString())
                                _signInUiState.value = _signInUiState.value.copy(
                                    isLoading = false
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    fun aldi() {
        viewModelScope.launch {
            authenticateUseCase()
        }
    }
}