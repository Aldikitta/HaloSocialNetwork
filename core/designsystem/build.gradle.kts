plugins {
    id("aldikitta.android.library")
    id("aldikitta.android.library.compose")
}

android {
    namespace = "com.aldikitta.designsystem"
}

dependencies {
    implementation(libs.androidx.core.core.ktx)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.material.icons.extended)
}