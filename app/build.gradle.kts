plugins {
    id("aldikitta.android.application")
    id("aldikitta.android.application.compose")
    id("aldikitta.android.hilt")
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
    implementation(project(":core:designsystem"))
    implementation(project(":authentication:signin"))
    implementation(project(":authentication:signup"))
    implementation(libs.androidx.activity.activity.compose)
    implementation(libs.androidx.core.core.splashscreen)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.material.icons.extended)
    implementation(libs.androidx.navigation.navigation.compose)
}