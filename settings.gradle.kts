pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "HollaHalo"
include(":app")
include(":core:data")
include(":authentication")
include(":authentication:sign_in")
include(":authentication:login")
include(":ui")
include(":core:model")
