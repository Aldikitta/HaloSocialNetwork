plugins {
    `kotlin-dsl`
}

group = "com.aldikitta.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.org.jetbrains.kotlinx.kotlinx.gradle.plugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.com.google.firebase.crashlytics.gradle)
    compileOnly(libs.com.google.firebase.performance.gradle)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "aldikitta.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "aldikitta.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "aldikitta.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "aldikitta.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidHilt") {
            id = "aldikitta.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidFeature") {
            id = "aldikitta.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidFirebase") {
            id = "aldikitta.android.application.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }
    }
}
