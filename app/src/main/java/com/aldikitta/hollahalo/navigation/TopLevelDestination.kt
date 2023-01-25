package com.aldikitta.hollahalo.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.aldikitta.designsystem.R

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int
) {
    FEED(
        selectedIcon = Icons.Default.Article,
        unselectedIcon = Icons.Default.Article,
        iconTextId = R.string.feed,
        titleTextId = R.string.feed
    ),
    PROFILE(
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Default.Person,
        iconTextId = R.string.profile,
        titleTextId = R.string.profile
    ),
}