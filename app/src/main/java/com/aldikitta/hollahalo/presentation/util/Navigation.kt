package com.aldikitta.hollahalo.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aldikitta.signin.LoginScreen
import com.aldikitta.signup.RegisterScreen
import com.aldikitta.hollahalo.presentation.feed.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            com.aldikitta.signin.LoginScreen(navController)
        }
        composable(route = Screen.RegisterScreen.route){
            com.aldikitta.signup.RegisterScreen(navController)
        }
        composable(route = Screen.MainFeedScreen.route){
            HomeScreen(navController)
        }
    }
}