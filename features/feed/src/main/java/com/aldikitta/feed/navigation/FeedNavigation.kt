package com.aldikitta.feed.navigation

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aldikitta.feed.FeedScreen
import com.aldikitta.model.Post

const val feedRoute = "feed_route"

fun NavController.navigateToFeed(navOptions: NavOptions? = null){
    this.navigate(feedRoute, navOptions)
}

fun NavGraphBuilder.feedScreen(
    navController: NavController,
    scrollState: LazyListState,
    onCommentClick: () -> Unit
){
    composable(route = feedRoute){
        FeedScreen(state = scrollState, onCommentClick = onCommentClick)
    }
}