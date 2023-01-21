plugins {
    id("aldikitta.android.library")
    id("aldikitta.android.hilt")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.signin"
}

dependencies {
    implementation(project(":designsystem"))
    implementation(libs.androidx.core.core.ktx)
    implementation(libs.androidx.lifecycle.lifecycle.runtime.compose)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.navigation.navigation.compose)
    implementation(libs.androidx.hilt.hilt.navigation.compose)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.material.icons.extended)
}