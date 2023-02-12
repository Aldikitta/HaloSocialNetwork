package com.aldikitta.data.repository.auth

import com.aldikitta.data.remote.auth.AuthApi
import com.aldikitta.data.remote.auth.dto.request.SignUpRequest
import com.aldikitta.data.util.Resource
import com.aldikitta.data.util.UiText
import javax.inject.Inject
import com.aldikitta.data.R
import com.aldikitta.data.dto.response.ApiResponse
import io.ktor.client.plugins.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException


class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {
    override suspend fun signUp(signUpRequest: SignUpRequest): Resource<Unit> {
        return try {
            val response = authApi.signUp(signUpRequest = signUpRequest)
            if (response.successful) {
                Resource.Loading(true)
                Resource.Success(Unit)
                Resource.Loading(false)
            } else {
                response.message?.let { msg ->
                    Resource.Error(uiText = UiText.DynamicString(msg))
                } ?: Resource.Error(uiText = UiText.StringResource(R.string.error_unknown))
                Resource.Loading(false)
            }
        } catch (e: IOException) {
            println("1")
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: Exception) {
            println("this is error ${e.message}")
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        } catch (e: RedirectResponseException) {
            println("3")
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_redirect_error)
            )
        } catch (e: ServerResponseException) {
            println("4")
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_server_error)
            )
        } catch (e: ClientRequestException) {
            println("5")
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_client_error)
            )
        }
    }
}