pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
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
include(":authentication:signin")
include(":authentication:signup")
include(":core:designsystem")
include(":core:data")
include(":features")
include(":features:feed")
include(":features:profile")
include(":core:model")
include(":features:chat")
include(":features:activity")
include(":core:domain")
include(":core:datastore")
include(":core:network")
include(":ui")
