package com.aldikitta.chat.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val chatRoute = "chat_route"

fun NavController.navigateToChat(navOptions: NavOptions? = null){
    this.navigate(chatRoute, navOptions)
}

fun NavGraphBuilder.chatScreen(
    navController: NavController
){
    composable(route = chatRoute){

    }
}