buildscript {
    repositories {
        google()
        mavenCentral()

        // Android Build Server
//        maven { url = uri("../nowinandroid-prebuilts/m2repository") }
    }
    dependencies {
        classpath("com.google.gms:google-services:4.3.15")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.4")
    }
}

plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.org.jetbrains.kotlin.serialization) apply false
    alias(libs.plugins.com.google.dagger.hilt.android) apply false
//    alias(libs.plugins.firebase.crashlytics) apply false
//    alias(libs.plugins.firebase.perf) apply false
//    alias(libs.plugins.gms) apply false
    alias(libs.plugins.ksp) apply false
//    alias(libs.plugins.com.google.gms) apply false
//    alias(libs.plugins.com.google.firebase.performance) apply false
//    alias(libs.plugins.com.google.firebase.crashlytics) apply false

    alias(libs.plugins.org.jetbrains.dokka)
    alias(libs.plugins.nl.littlerobots.version.catalog.update)
    alias(libs.plugins.com.github.ben.manes.versions)
}