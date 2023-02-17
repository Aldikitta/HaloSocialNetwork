package com.aldikitta.feed

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.aldikitta.feed.components.PostItem
import com.aldikitta.feed.util.PaletteGenerator.convertImageUrlToBitmap
import com.aldikitta.feed.util.PaletteGenerator.extractColorsFromBitmap
import com.aldikitta.model.Post

@Composable
fun FeedScreen(
    post: Post? = null,
    state: LazyListState,
    viewModel: FeedScreenViewModel = hiltViewModel()
) {
//    val context = LocalContext.current
//
//    var launchedEffectTrigerred by remember {
//        mutableStateOf(false)
//    }
//    val colorPalette by viewModel.colorPalette
//    val imageUrl = post!!.imageUrl

//    LaunchedEffect(key1 = true) {
//        try {
//            val bitmap = convertImageUrlToBitmap(
//                imageUrl = imageUrl,
//                context = context
//            )
//
//            if (bitmap != null) {
//                launchedEffectTrigerred = true
//                viewModel.setColorPalette(
//                    colors = extractColorsFromBitmap(
//                        bitmap = bitmap
//                    )
//                )
//            }
//        } catch (e: Exception) {
////            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
//        }
//    }
//    if (colorPalette.isNotEmpty() && launchedEffectTrigerred) {
        LazyColumn(state = state) {
            item {
                PostItem(
                    post = Post(
                        id = 1L,
                        username = "Ruby",
                        profilePictureUrl = "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=843&q=80",
                        imageUrl = "https://images.unsplash.com/photo-1674902096909-07a37724e4c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80",
                        description = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment",
                        likeCount = 123,
                        commentCount = 144
                    ),
                    onCommentClicked = {
                    },
                )
                PostItem(
                    post = Post(
                        id = 2L,
                        username = "Ruby",
                        profilePictureUrl = "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=843&q=80",
                        imageUrl = "https://images.unsplash.com/photo-1674902096909-07a37724e4c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80",
                        description = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment",
                        likeCount = 123,
                        commentCount = 144
                    ),
                    onCommentClicked = {
                    },
                )
                PostItem(
                    post = Post(
                        id = 3L,
                        username = "Ruby",
                        profilePictureUrl = "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=843&q=80",
                        imageUrl = "https://images.unsplash.com/photo-1674902096909-07a37724e4c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80",
                        description = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment",
                        likeCount = 123,
                        commentCount = 144
                    ),
                    onCommentClicked = {
                    },
                )
                PostItem(
                    post = Post(
                        id = 4L,
                        username = "Ruby",
                        profilePictureUrl = "https://images.unsplash.com/photo-1514888286974-6c03e2ca1dba?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=843&q=80",
                        imageUrl = "https://images.unsplash.com/photo-1674902096909-07a37724e4c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80",
                        description = "Night is where you see stars on the sky, light on the dark, it's so beautiful and all. Anyway this is comment",
                        likeCount = 123,
                        commentCount = 144
                    ),
                    onCommentClicked = {
                    },
                )
            }
        }
    }

