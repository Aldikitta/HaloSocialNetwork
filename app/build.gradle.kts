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
            isMinifyEnabled = false
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
//    implementation 'androidx.core:core-ktx:1.9.0'
//    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.5.1'
//    implementation 'androidx.activity:activity-compose:1.6.1'
//    implementation "androidx.compose.ui:ui:$compose_version"
//    implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
//    implementation 'androidx.compose.material3:material3:1.1.0-alpha04'
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
//    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
//    debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"
//    debugImplementation "androidx.compose.ui:ui-test-manifest:$compose_version"
//
//    //Window Adaptive layout
//    implementation "androidx.window:window:1.0.0"
//
//    //LifeCycle Compose
//    implementation "androidx.lifecycle:lifecycle-runtime-compose:2.6.0-alpha04"
//
//    //Icons-Extended
//    implementation "androidx.compose.material:material-icons-extended:1.3.1"
//
//    //SplashScreen
//    implementation("androidx.core:core-splashscreen:1.0.0")
//
//    //Navigation
//    implementation "androidx.navigation:navigation-compose:2.5.3"
//
//    //Dagger-hilt
//    implementation "com.google.dagger:hilt-android:2.44.2"
//    kapt "com.google.dagger:hilt-android-compiler:2.44.2"
//    implementation 'androidx.hilt:hilt-navigation-compose:1.0.0'
//    kapt "androidx.hilt:hilt-compiler:1.0.0"
//
//    //Retrofit
//    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
//    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
//    implementation "com.squareup.okhttp3:okhttp:5.0.0-alpha.9"
//    implementation "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.9"
//
//    // Timber
//    implementation 'com.jakewharton.timber:timber:5.0.1'
//
//    //Local Unit Test
//    implementation "androidx.test:core:1.5.0"
//    testImplementation "junit:junit:4.13.2"
//    testImplementation "org.hamcrest:hamcrest-all:1.3"
//    testImplementation "androidx.arch.core:core-testing:2.1.0"
//    testImplementation "org.robolectric:robolectric:4.8.1"
//    testImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2"
//    testImplementation "com.google.truth:truth:1.1.3"
//    testImplementation "com.squareup.okhttp3:mockwebserver:5.0.0-alpha.9"
//    testImplementation "io.mockk:mockk:1.12.3"
//    testImplementation "org.robolectric:robolectric:4.8.1"
//
//    androidTestImplementation 'com.google.dagger:hilt-android-testing:2.44.2'
//    kaptAndroidTest 'com.google.dagger:hilt-android-compiler:2.44.2'
//
//    // Instrumented Unit Tests
//    androidTestImplementation "junit:junit:4.13.2"
//    androidTestImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2"
//    androidTestImplementation "androidx.arch.core:core-testing:2.1.0"
//    androidTestImplementation "com.google.truth:truth:1.1.3"
//    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
//    androidTestImplementation 'androidx.test:core-ktx:1.5.0'
//    androidTestImplementation "com.squareup.okhttp3:mockwebserver:5.0.0-alpha.9"
//    androidTestImplementation "io.mockk:mockk-android:1.12.1"
}