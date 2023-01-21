package com.aldikitta.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.aldikitta.signin.SignInScreen

private const val signInGraphRoutePattern = "signIn_screen_graph"
const val signInRoute = "signIn_route"

fun NavController.navigateToSignInGraph(navOptions: NavOptions? = null) {
    this.navigate(signInGraphRoutePattern, navOptions)
}

fun NavGraphBuilder.signInGraph(
    navController: NavController,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = signInGraphRoutePattern,
        startDestination = signInRoute
    ) {
        composable(route = signInRoute) {
            SignInScreen(
                navController
            )
        }
        nestedGraphs()
    }
}