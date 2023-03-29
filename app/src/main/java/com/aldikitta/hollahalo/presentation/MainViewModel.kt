package com.aldikitta.hollahalo.presentation

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldikitta.data.repository.auth.AuthRepository
import com.aldikitta.data.util.Resource
import com.aldikitta.domain.usecase.auth.AuthenticateUseCase
import com.aldikitta.feed.navigation.feedRoute
import com.aldikitta.signin.navigation.signInGraphRoutePattern
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase,
) : ViewModel() {

    private val _startDestination = MutableStateFlow(UIState())
    val startDestination = _startDestination.asStateFlow()

    init {
        viewModelScope.launch {
            when (authenticateUseCase()) {
                is Resource.Error -> {
                    delay(10000)
                    _startDestination.value = _startDestination.value.copy(
                        startDestination = signInGraphRoutePattern
                    )
                    Log.d("TAG", "error: ")
                    _startDestination.value = _startDestination.value.copy(
                        isLoading = false
                    )
                }

                is Resource.Success -> {
                    delay(10000)
                    _startDestination.value = _startDestination.value.copy(
                        startDestination = feedRoute
                    )
                    Log.d("TAG", "success: ")
                    _startDestination.value = _startDestination.value.copy(
                        isLoading = false
                    )
                }

                else -> {
                    _startDestination.value = _startDestination.value.copy(
                        startDestination = signInGraphRoutePattern
                    )
                    Log.d("TAG", "else: ")
                    _startDestination.value = _startDestination.value.copy(
                        isLoading = false
                    )
                }
            }
        }
    }
}


@Immutable
data class UIState(
    val startDestination: String = signInGraphRoutePattern,
    val isLoading: Boolean = true
)

sealed interface MainActivityUiState {
    object Error : MainActivityUiState
    object Success : MainActivityUiState
}