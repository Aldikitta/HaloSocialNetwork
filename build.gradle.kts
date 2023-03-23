import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "org.jetbrains.dokka")

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
        android.set(true)
        ignoreFailures.set(false)
        disabledRules.set(setOf("final-newline", "no-wildcard-imports"))
        reporters {
            reporter(ReporterType.PLAIN)
            reporter(ReporterType.CHECKSTYLE)
            reporter(ReporterType.SARIF)
        }
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
    alias(libs.plugins.org.jlleitschuh.gradle.ktlint)
    alias(libs.plugins.org.jetbrains.dokka) apply false

    alias(libs.plugins.nl.littlerobots.version.catalog.update)
    alias(libs.plugins.com.github.ben.manes.versions)
}