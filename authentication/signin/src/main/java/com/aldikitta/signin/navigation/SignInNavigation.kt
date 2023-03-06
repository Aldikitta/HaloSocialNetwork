package com.aldikitta.signin.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.aldikitta.feed.navigation.navigateToFeed
import com.aldikitta.signin.SignInScreen

const val signInGraphRoutePattern = "signIn_screen_graph"
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
                navController = navController,
                onSignIn = {
//                    navController.navigateToFeed(
//                        navOptions {
//                            popUpTo(route = signInGraphRoutePattern) {
//                                inclusive = true
//                            }
//                        }
//                    )
                }
            )
        }
        nestedGraphs()
    }
}