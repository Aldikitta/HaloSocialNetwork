package com.aldikitta.feed

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.aldikitta.feed.components.CommentItem
import com.aldikitta.feed.components.PostItem
import com.aldikitta.model.Post
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    post: Post? = null,
    state: LazyListState,
    onCommentClick: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = {
            it != ModalBottomSheetValue.HalfExpanded
        },
        skipHalfExpanded = true
    )

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch {
            sheetState.hide()
        }
    }

    var text by rememberSaveable { mutableStateOf("") }

    ModalBottomSheetLayout(
        modifier = Modifier.fillMaxSize(),
        sheetBackgroundColor = MaterialTheme.colorScheme.surface,
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = {
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
    ) {
        LazyColumn(state = state) {
            item {
                PostItem(
                    post = Post(
                        username = "Ruby",
                        profilePictureUrl = "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=843&q=80",
                        imageUrl = "https://images.unsplash.com/photo-1674902096909-07a37724e4c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80",
                        description = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment",
                        likeCount = 123,
                        commentCount = 144
                    ),
                    onCommentClicked = {
                        onCommentClick()

                    }
                )
                PostItem(
                    post = Post(
                        username = "Ruby",
                        profilePictureUrl = "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=843&q=80",
                        imageUrl = "https://images.unsplash.com/photo-1674902096909-07a37724e4c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80",
                        description = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment",
                        likeCount = 123,
                        commentCount = 144
                    ),
                    onCommentClicked = {
                        coroutineScope.launch {
                            sheetState.show()
                        }
                    }
                )
                PostItem(
                    post = Post(
                        username = "Ruby",
                        profilePictureUrl = "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=843&q=80",
                        imageUrl = "https://images.unsplash.com/photo-1674902096909-07a37724e4c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80",
                        description = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment",
                        likeCount = 123,
                        commentCount = 144
                    ),
                    onCommentClicked = {
                        coroutineScope.launch {
                            sheetState.show()
                        }
                    }
                )
                PostItem(
                    post = Post(
                        username = "Ruby",
                        profilePictureUrl = "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=843&q=80",
                        imageUrl = "https://images.unsplash.com/photo-1674902096909-07a37724e4c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80",
                        description = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment",
                        likeCount = 123,
                        commentCount = 144
                    ),
                    onCommentClicked = {
                        coroutineScope.launch {
                            sheetState.show()
                        }
                    }
                )
            }
        }

    }
}

