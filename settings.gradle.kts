rootProject.name = "CodingChallenge"

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

include(":app")
include(":initializer:contract")
include(":initializer:implementation")
include(":data:api:contract")
include(":data:api:implementation")
include(":data:api:model")
include(":data:repository:contract")
include(":data:repository:implementation")
include(":domain:contract")
include(":domain:implementation")
include(":domain:model")
include(":di")
include(":ui:home")
include(":ui:common")
include(":navigation")
include(":data:datasource:contract")
include(":data:datasource:implementation")
include(":data:datasource:model")
