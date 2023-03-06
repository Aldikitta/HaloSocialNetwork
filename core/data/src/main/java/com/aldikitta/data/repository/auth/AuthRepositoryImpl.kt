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
import io.ktor.client.plugins.*
import io.ktor.utils.io.errors.*

class AuthRepositoryImpl @Inject constructor(
    private val authApi: KtorClientAuthApi,
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
        } catch (t: IOException) {
            println("Error IOException")
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (t: Exception) {
            println("Error Exception")
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )

        } catch (t: RedirectResponseException) {
            println("Error RedirectResponseException")
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_redirect_error)
            )
        } catch (t: ServerResponseException) {
            println("Error ServerResponseException")
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_server_error)
            )
        } catch (t: ClientRequestException) {
            println("Error ClientRequestException")
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_client_error)
            )
        }
//        return tryCatch {
//            val response = authApi.signUp(signUpRequest = signUpRequest)
//            if (response.successful) {
//                Resource.Success(Unit)
//            } else {
//                response.message?.let { msg ->
//                    Resource.Error(uiText = UiText.DynamicString(msg))
//                } ?: Resource.Error(uiText = UiText.StringResource(R.string.error_unknown))
//            }
//        }
    }

    override suspend fun signIn(signInRequest: SignInRequest): Resource<Unit> {
        val token = stringPreferencesKey("jwt_token")
        val userId = stringPreferencesKey("userId")

        return tryCatch {
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
        }
    }

    override suspend fun authenticate(): Resource<Unit> {
//        return tryCatch {
//            authApi.authenticate()
//            Resource.Success(Unit)
//        }
        return try {
            Resource.Success(
                authApi.authenticate()
            )
//            println("success with")
//            Resource.Success(Unit)
        } catch (e: Throwable) {
            println("error exception")
            Resource.Error()
        }


//        return try {
//            authApi.authenticate()
//            println("sukses")
//            Resource.Success(Unit)
//        } catch (e: IOException) {
//            Resource.Error(
//                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
//            )
//        } catch (e: Exception) {
//            Resource.Error(
//                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
//            )
//        } catch (e: RedirectResponseException) {
//            Resource.Error(
//                uiText = UiText.StringResource(R.string.oops_redirect_error)
//            )
//        } catch (e: ServerResponseException) {
//            Resource.Error(
//                uiText = UiText.StringResource(R.string.oops_server_error)
//            )
//        } catch (e: ClientRequestException) {
//            Resource.Error(
//                uiText = UiText.StringResource(R.string.oops_client_error)
//            )
//        }
    }
}