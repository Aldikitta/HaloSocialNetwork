package com.aldikitta.data.repository.auth

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.aldikitta.data.remote.auth.AuthApi
import com.aldikitta.data.remote.auth.dto.request.SignUpRequest
import com.aldikitta.data.util.Resource
import com.aldikitta.data.util.UiText
import javax.inject.Inject
import com.aldikitta.data.R
import com.aldikitta.data.remote.auth.dto.request.SignInRequest
import io.ktor.client.plugins.*
import java.io.IOException

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val dataStore: DataStore<Preferences>,
) : AuthRepository {
    override suspend fun signUp(signUpRequest: SignUpRequest): Resource<Unit> {
        return try {
            val response = authApi.signUp(signUpRequest = signUpRequest)
            if (response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(uiText = UiText.DynamicString(msg))
                } ?: Resource.Error(uiText = UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: Exception) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        } catch (e: RedirectResponseException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_redirect_error)
            )
        } catch (e: ServerResponseException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_server_error)
            )
        } catch (e: ClientRequestException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_client_error)
            )
        }
    }

    override suspend fun signIn(signInRequest: SignInRequest): Resource<Unit> {
        val token = stringPreferencesKey("jwt_token")
        val userId = stringPreferencesKey("userId")
        return try {
            val response = authApi.signIn(signInRequest = signInRequest)
            if (response.successful) {
                response.data?.let { authResponse ->
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
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: Exception) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        } catch (e: RedirectResponseException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_redirect_error)
            )
        } catch (e: ServerResponseException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_server_error)
            )
        } catch (e: ClientRequestException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_client_error)
            )
        }
    }
}