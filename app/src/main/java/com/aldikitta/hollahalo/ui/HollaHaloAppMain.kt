package com.aldikitta.hollahalo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aldikitta.data.util.NetworkMonitor
import com.aldikitta.hollahalo.R
import com.aldikitta.hollahalo.navigation.HollaHaloNavHost

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class,
    ExperimentalLayoutApi::class
)
@Composable
fun HollaHaloAppMain(
    networkMonitor: NetworkMonitor,
    windowSizeClass: WindowSizeClass,
    appState: HollaHaloAppState = rememberHollaHaloAppState(
        windowSizeClass = windowSizeClass,
        networkMonitor = networkMonitor
    )
) {
    val snackbarHostState = remember{
        SnackbarHostState()
    }

    val isOffline by appState.isOffline.collectAsStateWithLifecycle()

    val notConnectedMessage = stringResource(id = R.string.not_connected)
    LaunchedEffect(isOffline) {
        if (isOffline) snackbarHostState.showSnackbar(
            message = notConnectedMessage,
            duration = SnackbarDuration.Indefinite
        )
    }
    Scaffold(
        modifier = Modifier.semantics {
            testTagsAsResourceId = true
        },
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        bottomBar = {
            if (appState.shouldShowBottomBar){

            }
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .consumeWindowInsets(it)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal
                    )
                )
        ) {
            if (appState.shouldShowNavRail){

            }
            HollaHaloNavHost(navHostController = appState.navController)
        }
    }
}