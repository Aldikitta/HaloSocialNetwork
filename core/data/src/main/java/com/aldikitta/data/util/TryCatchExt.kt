package com.aldikitta.data.util

import com.aldikitta.data.R
import io.ktor.client.plugins.*
import io.ktor.utils.io.errors.*

inline fun tryCatch(block: () -> Resource<Unit>): Resource<Unit> {
    return try {
        block()
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
}