package com.aldikitta.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.aldikitta.core.data.LoginTokenPreferences
import com.aldikitta.datastore.UserPreferencesSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    fun providesUserPreferencesDataStore(
        @ApplicationContext context: Context,
        ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
        userPreferencesSerializer: UserPreferencesSerializer,
    ): DataStore<LoginTokenPreferences> = DataStoreFactory.create(
        serializer = userPreferencesSerializer,
        scope = CoroutineScope(ioDispatcher + SupervisorJob()),
    ){
        context.dataStoreFile("login_token_preferences.pb")
    }
}