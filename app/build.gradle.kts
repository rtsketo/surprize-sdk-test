plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
  namespace = "com.example.bottomnavtest"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.example.bottomnavtest"
    minSdk = 24
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(getDefaultProguardFile(
        "proguard-android-optimize.txt"),
        "proguard-rules.pro")
      signingConfig = signingConfigs.getByName("debug")
    }
  }

  packagingOptions {
    // Exclude these files
    exclude("META-INF/NOTICE.txt")
    exclude("guardit4j.fin")

    //LoyalKit
    resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    jniLibs.pickFirsts += setOf(
      "**/librsjni_androidx.so",
      "META-INF/androidx.*",
      "**/libRSSupport.so",
      "**/librsjni.so"
    )
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }

  buildFeatures {
    viewBinding = true
  }
}

dependencies {

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)
  implementation(libs.androidx.constraintlayout)
  implementation(libs.androidx.lifecycle.livedata.ktx)
  implementation(libs.androidx.lifecycle.viewmodel.ktx)
  implementation(libs.androidx.navigation.fragment.ktx)
  implementation(libs.androidx.navigation.ui.ktx)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  implementation(libs.sdk.test)
}