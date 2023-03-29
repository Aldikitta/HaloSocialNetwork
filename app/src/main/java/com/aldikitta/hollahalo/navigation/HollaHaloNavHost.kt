package com.aldikitta.hollahalo.navigation

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.aldikitta.activity.navigation.activityScreen
import com.aldikitta.chat.navigation.chatScreen
import com.aldikitta.feed.navigation.feedScreen
import com.aldikitta.hollahalo.presentation.MainViewModel
import com.aldikitta.profile.navigation.profileScreen
import com.aldikitta.signin.navigation.signInGraph
import com.aldikitta.signin.navigation.signInGraphRoutePattern
import com.aldikitta.signup.navigation.signUpScreen

@Composable
fun HollaHaloNavHost(
    navHostController: NavHostController,
    scrollState: LazyListState,
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val uiState by mainViewModel.startDestination.collectAsStateWithLifecycle()
    Log.d("TAG", "destination: ${uiState.startDestination}")
    NavHost(
        navController = navHostController,
//        startDestination = signInGraphRoutePattern
        startDestination = uiState.startDestination,
    ) {
        signInGraph(
            navController = navHostController,
            nestedGraphs = {
                signUpScreen(
                    navHostController
                )
            }
        )
        feedScreen(
            navHostController,
            scrollState = scrollState,
        )
        profileScreen(navHostController)
        chatScreen(navHostController)
        activityScreen(navHostController)
    }
}