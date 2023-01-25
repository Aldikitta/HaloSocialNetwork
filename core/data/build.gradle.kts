plugins {
    id("aldikitta.android.library")
    id("aldikitta.android.hilt")
}

android {
    namespace = "com.aldikitta.data"
}

dependencies {
    implementation(libs.androidx.core.core.ktx)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
    implementation(libs.javax.inject.javax.inject)
}