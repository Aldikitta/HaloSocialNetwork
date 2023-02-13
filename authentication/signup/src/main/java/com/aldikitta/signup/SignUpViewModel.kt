package com.aldikitta.signup

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldikitta.data.remote.auth.dto.request.SignUpRequest
import com.aldikitta.data.repository.auth.AuthRepository
import com.aldikitta.data.util.Resource
import com.aldikitta.data.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {
    private val _signUpUiState = MutableStateFlow(SignUpUiState())
    val signUpUiState = _signUpUiState.asStateFlow()

    private val _uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Initial)
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<SignUpEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _onRegister = MutableSharedFlow<Unit>(replay = 1)
    val onRegister = _onRegister.asSharedFlow()

    fun onEvent(signUpUiEvent: SignUpUiEvent) {
        when (signUpUiEvent) {
            is SignUpUiEvent.EmailInputText -> {
                _signUpUiState.value = _signUpUiState.value.copy(
                    emailText = signUpUiEvent.email.trim()
                )
            }
            is SignUpUiEvent.UsernameInputText -> {
                _signUpUiState.value = _signUpUiState.value.copy(
                    usernameText = signUpUiEvent.username.trim()
                )
            }
            is SignUpUiEvent.PasswordInputText -> {
                _signUpUiState.value = _signUpUiState.value.copy(
                    passwordText = signUpUiEvent.password.trim()
                )
            }
            is SignUpUiEvent.ConfirmPasswordInputText -> {
                _signUpUiState.value = _signUpUiState.value.copy(
                    confirmPasswordText = signUpUiEvent.confirmPassword.trim()
                )
            }
            is SignUpUiEvent.EmptyFieldEmail -> {
                _signUpUiState.value = _signUpUiState.value.copy(
                    emailText = _signUpUiState.value.emptyField
                )
            }
            is SignUpUiEvent.EmptyFieldUsername -> {
                _signUpUiState.value = _signUpUiState.value.copy(
                    usernameText = _signUpUiState.value.emptyField
                )
            }
            is SignUpUiEvent.EmptyFieldPassword -> {
                _signUpUiState.value = _signUpUiState.value.copy(
                    passwordText = _signUpUiState.value.emptyField
                )
            }
            is SignUpUiEvent.EmptyFieldConfirmPassword -> {
                _signUpUiState.value = _signUpUiState.value.copy(
                    confirmPasswordText = _signUpUiState.value.emptyField
                )
            }
            is SignUpUiEvent.ToggleVisibilityClick -> {
                _signUpUiState.value = _signUpUiState.value.copy(
                    toggleVisibility = !_signUpUiState.value.toggleVisibility
                )
            }
            is SignUpUiEvent.ValidateEmail -> {
                _signUpUiState.value = _signUpUiState.value.copy(
                    validateEmail = Patterns.EMAIL_ADDRESS.matcher(_signUpUiState.value.emailText)
                        .matches(),
                )
            }
            is SignUpUiEvent.ValidateUsername -> {
                val minUsernameLength = 3
                _signUpUiState.value = _signUpUiState.value.copy(
                    validateUsername = _signUpUiState.value.usernameText.isNotBlank() && _signUpUiState.value.usernameText.length >= minUsernameLength,
                )
            }
            is SignUpUiEvent.ValidatePassword -> {
                val passwordRegex =
                    "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{8,}".toRegex()
                _signUpUiState.value = _signUpUiState.value.copy(
                    validatePassword = passwordRegex.matches(_signUpUiState.value.passwordText)
                )
            }
            is SignUpUiEvent.ValidateConfirmPassword -> {
                _signUpUiState.value = _signUpUiState.value.copy(
                    validateConfirmPassword = _signUpUiState.value.passwordText == _signUpUiState.value.confirmPasswordText
                )
            }

            is SignUpUiEvent.ValidateForm -> {
                val passwordRegex =
                    "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{8,}".toRegex()
                _signUpUiState.value = _signUpUiState.value.copy(
                    validateEmail = Patterns.EMAIL_ADDRESS.matcher(_signUpUiState.value.emailText)
                        .matches(),
                    validateUsername = _signUpUiState.value.usernameText.isNotBlank(),
                    validatePassword = passwordRegex.matches(_signUpUiState.value.passwordText),
                    validateConfirmPassword = _signUpUiState.value.confirmPasswordText == _signUpUiState.value.passwordText
                )
            }
            is SignUpUiEvent.SignUp -> {
                signUp()
            }
        }
    }

    private fun signUp() {
//        viewModelScope.launch {
//            _signUpUiState.value = _signUpUiState.value.copy(
//                isLoading = true
//            )
//            authRepository.signUp(
//                signUpRequest = SignUpRequest(
//                    email = signUpUiState.value.emailText,
//                    username = signUpUiState.value.usernameText,
//                    password = signUpUiState.value.passwordText
//                )
//            ).let {
//                when (it) {
//                    is Resource.Success -> {
//                        _eventFlow.emit(
//                            SignUpEvent.ShowMessage(UiText.StringResource(R.string.successfully_signup))
//                        )
//                        _uiState.value = UIState.Success
//                        _signUpUiState.value = _signUpUiState.value.copy(
//                            isLoading = false
//                        )
//                    }
//                    is Resource.Loading -> {
//                        _uiState.value = UIState.Loading
//                        _signUpUiState.value = _signUpUiState.value.copy(
//                            isLoading = false
//                        )
//                    }
//                    is Resource.Error -> {
//                        _eventFlow.emit(
//                            SignUpEvent.ShowMessage(uiText = it.uiText ?: UiText.unknownError())
//                        )
//                        _uiState.value = UIState.Error(error = it.exception.toString())
//                        _signUpUiState.value = _signUpUiState.value.copy(
//                            isLoading = false
//                        )
//                    }
//                }
//            }

        viewModelScope.launch {
            _signUpUiState.value = _signUpUiState.value.copy(
                isLoading = true
            )
            val signUpResult = authRepository.signUp(
                signUpRequest = SignUpRequest(
                    email = signUpUiState.value.emailText,
                    username = signUpUiState.value.usernameText,
                    password = signUpUiState.value.passwordText
                )
            )
            when (signUpResult) {
                is Resource.Success -> {
                    _eventFlow.emit(
                        SignUpEvent.ShowMessage(UiText.StringResource(R.string.successfully_signup))
                    )
                    _onRegister.emit(Unit)
                    _uiState.value = UIState.Success
                    _signUpUiState.value = _signUpUiState.value.copy(
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    _uiState.value = UIState.Loading
                    _signUpUiState.value = _signUpUiState.value.copy(
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        SignUpEvent.ShowMessage(
                            uiText = signUpResult.uiText ?: UiText.unknownError()
                        )
                    )
                    _uiState.value = UIState.Error(error = signUpResult.exception.toString())
                    _signUpUiState.value = _signUpUiState.value.copy(
                        isLoading = false
                    )
                }
            }
        }
    }
}