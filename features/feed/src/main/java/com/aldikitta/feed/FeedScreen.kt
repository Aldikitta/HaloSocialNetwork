package com.aldikitta.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.aldikitta.designsystem.theme.spacing
import com.aldikitta.feed.components.PostItem
import com.aldikitta.model.Post

@Composable
fun FeedScreen(
    post: Post? = null
) {
    PostItem(
        post = Post(
            username = "Ruby",
            imageUrl = "",
            profilePictureUrl = "",
            description = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment",
            likeCount = 123,
            commentCount = 144
        )
    )
}

