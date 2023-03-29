package com.aldikitta.hollahalo.ui

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.aldikitta.data.util.NetworkMonitor
import com.aldikitta.hollahalo.R
import com.aldikitta.hollahalo.navigation.HollaHaloNavHost
import com.aldikitta.hollahalo.navigation.TopLevelDestination

@OptIn(
    ExperimentalComposeUiApi::class,
)
@Composable
fun HollaHaloAppMain(
    networkMonitor: NetworkMonitor,
    windowSizeClass: WindowSizeClass,
    appState: HollaHaloAppState = rememberHollaHaloAppState(
        windowSizeClass = windowSizeClass,
        networkMonitor = networkMonitor
    )
) {
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val isOffline by appState.isOffline.collectAsStateWithLifecycle()

    val notConnectedMessage = stringResource(id = R.string.not_connected)
    LaunchedEffect(isOffline) {
        if (isOffline) snackbarHostState.showSnackbar(
            message = notConnectedMessage,
            duration = SnackbarDuration.Indefinite
        )
    }

    val scrollState = rememberLazyListState()

    val hideBottomBarWhenScrolling = !scrollState.isScrollInProgress

    val density = LocalDensity.current

    Scaffold(
        modifier = Modifier
            .semantics {
                testTagsAsResourceId = true
            },
        containerColor = MaterialTheme.colorScheme.inverseOnSurface,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        bottomBar = {
            val destination = appState.currentTopLevelDestination

            if (destination != null) {
                if (appState.shouldShowBottomBar) {
                    AnimatedVisibility(
                        visible = appState.shouldShowBottomBar && hideBottomBarWhenScrolling,
                        enter = slideInVertically {
                            // Slide in from 40 dp from the top.
                            with(density) { -40.dp.roundToPx() }
                        } + expandVertically(
                            // Expand from the top.
                            expandFrom = Alignment.Top
                        ),
                        exit = slideOutVertically() + shrinkVertically(shrinkTowards = Alignment.Bottom) + fadeOut()
                    ) {
                        HollaHaloBottomAppBar(
                            destinations = appState.topLevelDestinations,
                            onNavigateToDestination = appState::navigateToTopLevelDestination,
                            currentDestination = appState.currentDestination,
                            modifier = Modifier.testTag("HollaHaloBottomBar"),
                        )
                    }
                }
            }

        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
//                .consumeWindowInsets(it)
//                .windowInsetsPadding(
//                    WindowInsets.safeDrawing.only(
//                        WindowInsetsSides.Horizontal
//                    )
//                )
        ) {
            if (appState.shouldShowNavRail) {
                AnimatedVisibility(visible = appState.shouldShowNavRail) {
                    HollaHaloNavRail(
                        destinations = appState.topLevelDestinations,
                        onNavigateToDestination = appState::navigateToTopLevelDestination,
                        currentDestination = appState.currentDestination,
                        modifier = Modifier
                            .testTag("HollaHaloNavRail")
                            .safeDrawingPadding()
                    )
                }
            }
            HollaHaloNavHost(
                navHostController = appState.navController,
                scrollState = scrollState,
            )
        }
    }
}

@Composable
private fun HollaHaloBottomAppBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {

    BottomAppBar(
        modifier= modifier,
        containerColor = MaterialTheme.colorScheme.inverseOnSurface,
        actions = {
            destinations.forEach {
                val selected = currentDestination.isTopLevelDestinationInHierarchy(it)
                IconButton(onClick = { onNavigateToDestination(it) }) {
                    val icon = if (selected) {
                        it.selectedIcon
                    } else {
                        it.unselectedIcon
                    }
                    Icon(imageVector = icon, contentDescription = null)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        }
    )
}

@Composable
private fun HollaHaloNavRail(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    NavigationRail(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.inverseOnSurface,
        header = {
            FloatingActionButton(
                onClick = { /* do something */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        }
    ) {
        destinations.forEach {
            val selected = currentDestination.isTopLevelDestinationInHierarchy(it)
            NavigationRailItem(
                selected = selected,
                onClick = { onNavigateToDestination(it) },
                icon = {
                    val icon = if (selected) {
                        it.selectedIcon
                    } else {
                        it.unselectedIcon
                    }
                    Icon(imageVector = icon, contentDescription = null)
                },
                label = {
                    Text(text = stringResource(it.iconTextId))
                }
            )
        }
    }
}

@Composable
private fun HollaHaloBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.inverseOnSurface,
    ) {
        destinations.forEach {
            val selected = currentDestination.isTopLevelDestinationInHierarchy(it)
            NavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(it) },
                icon = {
                    val icon = if (selected) {
                        it.selectedIcon
                    } else {
                        it.unselectedIcon
                    }
                    Icon(imageVector = icon, contentDescription = null)
                },
                label = {
                    Text(text = stringResource(it.iconTextId))
                }
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false