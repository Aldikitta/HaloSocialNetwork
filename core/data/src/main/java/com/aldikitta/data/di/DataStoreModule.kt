package com.aldikitta.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

//@Module
//@InstallIn
//object DataStoreModule {
//    @Provides
//    @Singleton
//    fun providesUserPreferencesDataStore(
//        @ApplicationContext context: Context,
//        @Dispatcher(IO) ioDispatcher: CoroutineDispatcher,
//        ataStoreSerializer: DataStoreSerializer,
//    ): DataStore<UserPr>
//}