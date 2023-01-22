plugins {
    id("aldikitta.android.library")
    id("aldikitta.android.hilt")
    id("aldikitta.android.feature")
}

android {
    namespace = "com.aldikitta.signin"
}

dependencies {
    implementation(project(":authentication:signup"))
}