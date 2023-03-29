package com.aldikitta.hollahalo.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aldikitta.data.util.NetworkMonitor
import com.aldikitta.designsystem.theme.HollaHaloTheme
import com.aldikitta.hollahalo.ui.HollaHaloAppMain
import com.aldikitta.signin.navigation.signInGraphRoutePattern
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition{
            mainViewModel.startDestination.value.isLoading
        }
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            HollaHaloTheme {
                HollaHaloAppMain(
                    networkMonitor = networkMonitor, windowSizeClass = calculateWindowSizeClass(
                        activity = this
                    )
                )
            }
        }
    }
}
