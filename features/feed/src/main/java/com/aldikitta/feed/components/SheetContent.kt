package com.aldikitta.feed.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aldikitta.designsystem.theme.spacing
import com.aldikitta.feed.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SheetContent() {
    var text by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            modifier = Modifier.width(MaterialTheme.spacing.extraLarge).padding(top = MaterialTheme.spacing.medium),
            thickness = MaterialTheme.spacing.extraSmall
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
        LazyColumn(state = rememberLazyListState()) {
            item {
                CommentItem()
                CommentItem()
                CommentItem()
                CommentItem()
            }

        }
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
        Divider()
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
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
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text, onValueChange = { text = it },
                placeholder = {
                    Text(text = "Add Comment")
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = MaterialTheme.shapes.extraLarge
            )
        }
    }
}