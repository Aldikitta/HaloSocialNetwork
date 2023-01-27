package com.aldikitta.hollahalo.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.aldikitta.designsystem.R

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int
) {
    FEED(
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconTextId = R.string.feed,
        titleTextId = R.string.feed
    ),
    ACTIVITY(
        selectedIcon = Icons.Default.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
        iconTextId = R.string.activity,
        titleTextId = R.string.activity
    ),
    CHAT(
        selectedIcon = Icons.Default.Chat,
        unselectedIcon = Icons.Outlined.Article,
        iconTextId = R.string.chat,
        titleTextId = R.string.chat
    ),
    PROFILE(
        selectedIcon = Icons.Default.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle,
        iconTextId = R.string.profile,
        titleTextId = R.string.profile
    ),
}