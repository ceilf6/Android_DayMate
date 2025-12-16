pluginManagement {
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

rootProject.name = "DayMate"

// Android 原生应用
include(":apps:android-calendar")

// 共享模块
include(":shared:core")
include(":shared:ui-android")

// 可选：React Native 的 Android 部分可以单独构建
// include(":apps:rn-calendar:android:app")
