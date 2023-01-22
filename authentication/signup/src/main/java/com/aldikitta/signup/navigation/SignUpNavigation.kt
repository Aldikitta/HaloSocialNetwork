package com.aldikitta.signup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aldikitta.signup.SignUpScreen

const val signUpRoute = "signUp_route"

fun NavController.navigateToSignUpScreen(navOptions: NavOptions? = null) {
    this.navigate(signUpRoute, navOptions)
}

fun NavGraphBuilder.signUpScreen(
    navController: NavController
) {
    composable(route = signUpRoute) {
        SignUpScreen(
            navController
        )
    }
}