package com.aldikitta.feed.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aldikitta.designsystem.theme.spacing
import com.aldikitta.feed.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentItem() {
    Column(
    modifier = Modifier.padding(MaterialTheme.spacing.medium),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=843&q=80")
                            .crossfade(true)
                            .build(),
                        contentDescription = stringResource(id = R.string.profile_picture),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(MaterialTheme.spacing.large),
                    )
                    Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
                    Text(text = "The Cat")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = stringResource(id = R.string.like)
                    )
                    Text(
                        modifier = Modifier.padding(MaterialTheme.spacing.small),
                        text = "133",
                    )
                }
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
            Text(text = "This is some comment from user we try adding more line to see if its works as intended and yeah seems like it works ...")
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            Text(
                text = "2 Days ago",
                color = MaterialTheme.colorScheme.outline,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}