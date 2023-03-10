plugins {
    id("aldikitta.android.library")
    id("aldikitta.android.library.compose")
}

android {
    namespace = "com.aldikitta.ui"
}

dependencies {
    implementation(libs.androidx.core.core.ktx)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material.material.icons.extended)
    api(libs.androidx.compose.ui.ui.tooling.preview)
    debugApi(libs.androidx.compose.ui.ui.tooling.preview)
}