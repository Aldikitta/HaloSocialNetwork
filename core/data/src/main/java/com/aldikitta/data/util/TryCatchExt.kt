package com.aldikitta.data.util

import android.util.Log
import com.aldikitta.data.R
import io.ktor.client.plugins.*
import io.ktor.utils.io.errors.*

inline fun tryCatch(block: () -> Resource<Unit>): Resource<Unit> {
    return try {
        block()
    } catch (t: IOException) {
        Log.d("tryCatch","Error IOException: ${t.message}")
        Resource.Error(
            uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
        )
    } catch (t: Exception) {
        Log.d("tryCatch","Error Exception: ${t.message}")
        Resource.Error(
            uiText = UiText.StringResource(R.string.oops_something_went_wrong)
        )
    } catch (t: RedirectResponseException) {
        Log.d("tryCatch","Error RedirectResponseException: ${t.message}")
        Resource.Error(
            uiText = UiText.StringResource(R.string.oops_redirect_error)
        )
    } catch (t: ServerResponseException) {
        Log.d("tryCatch","Error ServerResponseException: ${t.message}")
        Resource.Error(
            uiText = UiText.StringResource(R.string.oops_server_error)
        )
    } catch (t: ClientRequestException) {
        Log.d("tryCatch","Error ClientRequestException: ${t.message}")
        Resource.Error(
            uiText = UiText.StringResource(R.string.oops_client_error)
        )
    }
}