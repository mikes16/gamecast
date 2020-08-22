plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android")
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        applicationId = "com.gamecastonline.gamecast"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
    }

    buildTypes {
        getByName("release") {
            resValue("string", "app_version", Versions.versionName)
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            versionNameSuffix = "debug"
            applicationIdSuffix = ".debug"
            resValue("string", "app_version", Versions.versionName)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(project(":network"))
    implementation(project(":utils"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.lifeCycleLD)
    implementation(Dependencies.AndroidX.supportAnimation)
    implementation(Dependencies.AndroidX.viewPager2)

    // Glide
    implementation(Dependencies.Glide.core)
    kapt(Dependencies.Glide.kapt)

    // DI
    implementation(Dependencies.Koin.core)
    implementation(Dependencies.Koin.scope)
    implementation(Dependencies.Koin.viewModel)

    // Nav component
    implementation(Dependencies.AndroidX.NavigationComponent.fragment)
    implementation(Dependencies.AndroidX.NavigationComponent.ui)

    testImplementation(TestDependencies.JUnit.core)
    androidTestImplementation(TestDependencies.JUnit.ext)
    androidTestImplementation(TestDependencies.Espresso.core)
}