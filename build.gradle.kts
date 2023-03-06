buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.org.jetbrains.kotlin.serialization) apply false
    alias(libs.plugins.com.google.dagger.hilt.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.com.google.gms) apply false
    alias(libs.plugins.com.google.firebase.performance) apply false
    alias(libs.plugins.com.google.firebase.crashlytics) apply false

    alias(libs.plugins.org.jetbrains.dokka)
    alias(libs.plugins.nl.littlerobots.version.catalog.update)
    alias(libs.plugins.com.github.ben.manes.versions)
    id("com.android.library") version "7.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
}