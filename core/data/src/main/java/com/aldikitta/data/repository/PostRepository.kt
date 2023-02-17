package com.aldikitta.data.repository

import com.aldikitta.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPost(): Flow<List<Post>>
}