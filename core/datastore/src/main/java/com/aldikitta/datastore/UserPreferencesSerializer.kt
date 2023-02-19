package com.aldikitta.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.aldikitta.core.data.LoginTokenPreferences
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class UserPreferencesSerializer @Inject constructor() : Serializer<LoginTokenPreferences> {
    override val defaultValue: LoginTokenPreferences
        get() = LoginTokenPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): LoginTokenPreferences {
        return try {
            // readFrom is already called on the data store background thread
            @Suppress("BlockingMethodInNonBlockingContext")
            LoginTokenPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto:", exception)
        }
    }

    override suspend fun writeTo(t: LoginTokenPreferences, output: OutputStream) {
        // writeTo is already called on the data store background thread
        @Suppress("BlockingMethodInNonBlockingContext")
        t.writeTo(output)
    }
}