plugins {
    id("aldikitta.android.library")
    id("aldikitta.android.hilt")
//    alias(libs.plugins.org.jetbrains.dokka)
}

android {
    namespace = "com.aldikitta.domain"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:data"))
    implementation(libs.androidx.core.core.ktx)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
    implementation(libs.javax.inject.javax.inject)

    //Ktor-Client
    implementation(libs.io.ktor.ktor.client.android)
    implementation(libs.io.ktor.ktor.client.serialization)
    implementation(libs.io.ktor.ktor.client.content.negotiation)
    implementation(libs.io.ktor.ktor.serialization.kotlinx.json)
    implementation(libs.io.ktor.ktor.client.logging.jvm)
}