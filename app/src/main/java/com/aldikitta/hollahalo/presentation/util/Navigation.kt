package com.aldikitta.hollahalo.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aldikitta.hollahalo.presentation.auth.login.LoginScreen
import com.aldikitta.hollahalo.presentation.auth.register.RegisterScreen
import com.aldikitta.hollahalo.presentation.feed.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.RegisterScreen.route){
            RegisterScreen(navController)
        }
        composable(route = Screen.MainFeedScreen.route){
            HomeScreen(navController)
        }
    }
}