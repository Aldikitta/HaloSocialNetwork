plugins {
    id("aldikitta.android.library")
    id("aldikitta.android.library.compose")
    id("aldikitta.android.feature")
//    alias(libs.plugins.org.jetbrains.dokka)
}

android {
    namespace = "com.aldikitta.feed"
}

dependencies {
    implementation(libs.androidx.palette)
}