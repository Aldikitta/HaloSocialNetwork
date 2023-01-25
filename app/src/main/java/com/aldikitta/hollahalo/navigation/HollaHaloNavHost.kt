package com.aldikitta.hollahalo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.aldikitta.signin.navigation.signInGraph
import com.aldikitta.signin.navigation.signInRoute
import com.aldikitta.signup.navigation.signUpRoute
import com.aldikitta.signup.navigation.signUpScreen

@Composable
fun HollaHaloNavHost(
    navHostController: NavHostController,
    startDestination: String = signUpRoute
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
    }
}