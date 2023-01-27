package com.aldikitta.hollahalo.ui

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.aldikitta.activity.navigation.navigateToActivity
import com.aldikitta.chat.navigation.navigateToChat
import com.aldikitta.data.util.NetworkMonitor
import com.aldikitta.feed.navigation.feedRoute
import com.aldikitta.feed.navigation.navigateToFeed
import com.aldikitta.hollahalo.navigation.TopLevelDestination
import com.aldikitta.profile.navigation.navigateToProfile
import com.aldikitta.profile.navigation.profileRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberHollaHaloAppState(
    windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): HollaHaloAppState {
    return remember(navController, coroutineScope, windowSizeClass, networkMonitor) {
        HollaHaloAppState(navController, coroutineScope, windowSizeClass, networkMonitor)
    }
}

@Stable
class HollaHaloAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
    @Composable get() = when (currentDestination?.route){
        feedRoute -> TopLevelDestination.FEED
        profileRoute -> TopLevelDestination.PROFILE
        else -> null
    }

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact ||
                windowSizeClass.heightSizeClass == WindowHeightSizeClass.Compact

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_0000),
            initialValue = false
        )

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination){
        trace("Navigation: ${topLevelDestination.name}"){
            val topLevelNavOptions = navOptions{
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination){
                TopLevelDestination.FEED -> navController.navigateToFeed (topLevelNavOptions)
                TopLevelDestination.ACTIVITY -> navController.navigateToActivity (topLevelNavOptions)
                TopLevelDestination.CHAT -> navController.navigateToChat (topLevelNavOptions)
                TopLevelDestination.PROFILE -> navController.navigateToProfile(topLevelNavOptions)
            }
        }
    }
}