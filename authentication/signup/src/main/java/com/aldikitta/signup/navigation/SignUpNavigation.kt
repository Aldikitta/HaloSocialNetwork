package com.aldikitta.signup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation

private const val signUpGraphRoutePattern = "signUp_screen_graph"
const val signUpRoute = "signUp_route"

fun NavController.navigateToSignUpGraph(navOptions: NavOptions? = null) {
    this.navigate(signUpGraphRoutePattern, navOptions)
}

fun NavGraphBuilder.signUpGraph(
    navController: NavController,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = signUpGraphRoutePattern,
        startDestUpation = signUpRoute
    ) {
        composable(route = signUpRoute) {
            SignUpScreen(
                navController
            )
        }
        nestedGraphs()
    }
}