plugins {
    id("aldikitta.android.application")
    id("aldikitta.android.application.compose")
    id("aldikitta.android.hilt")
    id("kotlinx-serialization")
//    id("nowinandroid.android.application.firebase")
    id("com.google.firebase.crashlytics")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.aldikitta.hollahalo"

    defaultConfig {
        applicationId = "com.aldikitta.hollahalo"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:designsystem"))
    implementation(project(":authentication:signin"))
    implementation(project(":authentication:signup"))
    implementation(project(":features:feed"))
    implementation(project(":features:profile"))
    implementation(project(":features:chat"))
    implementation(project(":features:activity"))
    implementation(libs.androidx.activity.activity.compose)
    implementation(libs.androidx.core.core.splashscreen)
    implementation(libs.androidx.lifecycle.lifecycle.runtime.compose)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material3.window)
    implementation(libs.androidx.compose.material.material.icons.extended)
    implementation(libs.androidx.navigation.navigation.compose)
    implementation(libs.androidx.tracing)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.ui.tooling.preview)



    implementation(platform("com.google.firebase:firebase-bom:31.2.2"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx:21.2.0")

}