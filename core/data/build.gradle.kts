plugins {
    id("aldikitta.android.library")
    id("aldikitta.android.hilt")
    id("kotlinx-serialization")
//    alias(libs.plugins.com.google.protobuf)
//    alias(libs.plugins.org.jetbrains.dokka)
}

android {
    namespace = "com.aldikitta.data"
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.androidx.core.core.ktx)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
    implementation(libs.javax.inject.javax.inject)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.ui)

    //Ktor-Client
    implementation(libs.io.ktor.ktor.client.android)
    implementation(libs.io.ktor.ktor.client.serialization)
    implementation(libs.io.ktor.ktor.client.content.negotiation)
    implementation(libs.io.ktor.ktor.serialization.kotlinx.json)
    implementation(libs.io.ktor.ktor.client.logging.jvm)

    //Datastore-Protobuf
    implementation(libs.androidx.datastore.datastore.preferences)
//    implementation(com.google.protobuf.javalite)
}