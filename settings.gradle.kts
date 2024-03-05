import org.gradle.api.initialization.resolve.RepositoriesMode.FAIL_ON_PROJECT_REPOS

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
  repositoriesMode.set(FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
    maven {
      url = uri("https://maven.pkg.github.com/axiomc/LoyalKit")
      credentials {
        // GitHub credentials for LoyalKit SDK
        username = ""
        password = ""
      }
    }
  }
}

rootProject.name = "bottomnavtest"
include(":app")
 