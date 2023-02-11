package com.aldikitta.data.repository

import com.aldikitta.data.dummy.PostDataProvider
import com.aldikitta.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostRepositoryImpl: PostRepository {
    override fun getPost(): Flow<List<Post>> = flow {
        emit(PostDataProvider.post)
    }.flowOn(Dispatchers.Main)
}