package com.aldikitta.hollahalo.presentation

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldikitta.data.repository.auth.AuthRepository
import com.aldikitta.data.util.Resource
import com.aldikitta.domain.usecase.auth.AuthenticateUseCase
import com.aldikitta.feed.navigation.feedRoute
import com.aldikitta.signin.navigation.signInGraphRoutePattern
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase
//    private val authRepository: AuthRepository
) : ViewModel() {

    private val _startDestination =
        MutableStateFlow(UIState(startDestination = signInGraphRoutePattern))
    val startDestination = _startDestination.asStateFlow()

    init {
//        viewModelScope.launch {
//            when (authenticateUseCase()) {
//                is Resource.Error -> {
////                        _startDestination.value = _startDestination.value.copy(
////                            startDestination = signInGraphRoutePattern
////                        )
//                    println("error")
//                }
//                is Resource.Success -> {
////                        _startDestination.value = _startDestination.value.copy(
////                            startDestination = feedRoute
////                        )
//                    println("success")
//                }
//                else -> {
//                    _startDestination.value = _startDestination.value.copy(
//                        startDestination = signInGraphRoutePattern
//                    )
//                }
//            }
//        }
    }
}


@Immutable
data class UIState(
    val startDestination: String = "",
)

sealed interface MovieDetailUIState {
    object Nothing : MovieDetailUIState
    object Loading : MovieDetailUIState
    object Success : MovieDetailUIState

    data class Error(val error: String) : MovieDetailUIState
}