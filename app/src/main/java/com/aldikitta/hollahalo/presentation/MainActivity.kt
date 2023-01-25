package com.aldikitta.hollahalo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.aldikitta.data.util.NetworkMonitor
import com.aldikitta.designsystem.theme.HollaHaloTheme
import com.aldikitta.hollahalo.ui.HollaHaloAppMain
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        setContent {
            HollaHaloTheme {
                // A surface container using the 'background' color from the theme
                HollaHaloAppMain(
                    networkMonitor = networkMonitor, windowSizeClass = calculateWindowSizeClass(
                        activity = this
                    )
                )
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//
//                }
            }
        }
    }
}
