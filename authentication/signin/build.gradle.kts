plugins {
    id("aldikitta.android.library")
    id("aldikitta.android.library.compose")
    id("aldikitta.android.hilt")
    id("aldikitta.android.feature")
//    alias(libs.plugins.org.jetbrains.dokka)
}

android {
    namespace = "com.aldikitta.signin"
}

dependencies {
    implementation(project(":authentication:signup"))
    implementation(project(":features:feed"))
}