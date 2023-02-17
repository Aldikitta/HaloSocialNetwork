package com.aldikitta.activity.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aldikitta.activity.ActivityScreen

const val activityRoute = "activity_route"

fun NavController.navigateToActivity(navOptions: NavOptions? = null){
    this.navigate(activityRoute, navOptions)
}

fun NavGraphBuilder.activityScreen(
    navController: NavController
){
    composable(route = activityRoute){
        ActivityScreen()
    }
}