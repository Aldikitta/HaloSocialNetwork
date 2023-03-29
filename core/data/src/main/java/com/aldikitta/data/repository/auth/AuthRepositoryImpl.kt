package com.aldikitta.data.repository.auth

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.aldikitta.auth.dto.request.SignInRequest
import com.aldikitta.auth.dto.request.SignUpRequest
import com.aldikitta.data.util.Resource
import com.aldikitta.data.util.UiText
import javax.inject.Inject
import com.aldikitta.data.R
import com.aldikitta.data.util.tryCatch
import com.aldikitta.network.ktor_client.auth.KtorClientAuthApi

class AuthRepositoryImpl @Inject constructor(
    private val authApi: KtorClientAuthApi,
    private val dataStore: DataStore<Preferences>,
) : AuthRepository {
    override suspend fun signUp(signUpRequest: SignUpRequest): Resource<Unit> {
        return tryCatch {
            val response = authApi.signUp(signUpRequest = signUpRequest)
            if (response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(uiText = UiText.DynamicString(msg))
                } ?: Resource.Error(uiText = UiText.StringResource(R.string.error_unknown))
            }
        }
    }

    override suspend fun signIn(signInRequest: SignInRequest): Resource<Unit> {
        val token = stringPreferencesKey("jwt_token")
        val userId = stringPreferencesKey("userId")

        return tryCatch {
            val response = authApi.signIn(signInRequest = signInRequest)
            if (response.successful) {
                response.data?.let { authResponse ->
                    println("Overriding token with ${authResponse.token}")
                    dataStore.edit { pref ->
                        pref[token] = authResponse.token
                        pref[userId] = authResponse.userId
                    }
                }
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(uiText = UiText.DynamicString(msg))
                } ?: Resource.Error(uiText = UiText.StringResource(R.string.error_unknown))
            }
        }
    }

    override suspend fun authenticate(): Resource<Unit> {
        return tryCatch {
            authApi.authenticate()
            Resource.Success(Unit)
        }
    }
}