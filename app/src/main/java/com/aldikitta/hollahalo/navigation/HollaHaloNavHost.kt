package com.aldikitta.hollahalo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.aldikitta.activity.navigation.activityScreen
import com.aldikitta.chat.navigation.chatScreen
import com.aldikitta.feed.navigation.feedRoute
import com.aldikitta.feed.navigation.feedScreen
import com.aldikitta.profile.navigation.profileScreen
import com.aldikitta.signin.navigation.signInGraph
import com.aldikitta.signin.navigation.signInGraphRoutePattern
import com.aldikitta.signin.navigation.signInRoute
import com.aldikitta.signup.navigation.signUpRoute
import com.aldikitta.signup.navigation.signUpScreen

@Composable
fun HollaHaloNavHost(
    navHostController: NavHostController,
    startDestination: String = feedRoute
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        signInGraph(
            navController = navHostController,
            nestedGraphs = {
                signUpScreen(
                    navHostController
                )
            }
        )
        feedScreen(navHostController)
        profileScreen(navHostController)
        chatScreen(navHostController)
        activityScreen(navHostController)
    }
}