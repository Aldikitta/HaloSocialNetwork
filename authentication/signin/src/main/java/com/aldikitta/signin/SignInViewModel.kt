package com.aldikitta.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldikitta.data.remote.auth.dto.request.SignInRequest
import com.aldikitta.data.remote.auth.dto.request.SignUpRequest
import com.aldikitta.data.repository.auth.AuthRepository
import com.aldikitta.data.util.Resource
import com.aldikitta.data.util.UiText
import com.aldikitta.signup.R
import com.aldikitta.signup.SignUpEvent
import com.aldikitta.signup.SignUpUiState
import com.aldikitta.signup.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading)
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

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
                    authRepository.signIn(
                        signInRequest = SignInRequest(
                            email = signInUiState.value.usernameText,
                            password = signInUiState.value.passwordText
                        )
                    ).let {
                        when (it) {
                            is Resource.Success -> {
                                _eventFlow.emit(
                                    SignInEvent.ShowMessage(UiText.StringResource(R.string.successfully_signup))
                                )
                                _uiState.value = UIState.Success
                                _signInUiState.value = _signInUiState.value.copy(
                                    isLoading = false
                                )
                            }
                            is Resource.Loading -> {
                                _uiState.value = UIState.Loading
                                _signInUiState.value = _signInUiState.value.copy(
                                    isLoading = false
                                )
                            }
                            is Resource.Error -> {
                                _eventFlow.emit(
                                    SignInEvent.ShowMessage(
                                        uiText = it.uiText ?: UiText.unknownError()
                                    )
                                )
                                _uiState.value = UIState.Error(error = it.exception.toString())
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
}