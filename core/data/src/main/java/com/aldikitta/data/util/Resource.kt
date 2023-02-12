package com.aldikitta.data.util

import kotlinx.coroutines.flow.*

sealed interface Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>
    data class Error(val exception: Throwable? = null, val uiText: UiText? = null) : Resource<Nothing>
    data class Loading(val status: Boolean) : Resource<Nothing>
}

fun <T> Flow<T>.asResource(): Flow<Resource<T>> {
    return this
        .map<T, Resource<T>> {
            Resource.Success(it)
        }
        .onStart { emit(Resource.Loading(true)) }
        .onCompletion { emit(Resource.Loading(false)) }
        .catch { error ->
            emit(Resource.Error(Throwable(message = error.message)))
            emit(Resource.Error(error))
            emit(Resource.Loading(false))
        }
}