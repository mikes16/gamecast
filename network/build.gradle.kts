plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
    }
    
    val backEndUrl = "BACKEND_URL"

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

            buildConfigField("String", backEndUrl, "\"https://1q7kvx9lm7.execute-api.us-east-1.amazonaws.com/dev/\"")
        }
        getByName("debug") {
            buildConfigField("String", backEndUrl, "\"https://1q7kvx9lm7.execute-api.us-east-1.amazonaws.com/dev/\"")
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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appCompat)

    // Retrofit
    api(Dependencies.Squareup.retrofit)
    implementation(Dependencies.Squareup.gsonConverter)

    // OkHttp
    implementation(Dependencies.Squareup.okhttpLI)

    // Test
    testImplementation(TestDependencies.JUnit.core)
    androidTestImplementation(TestDependencies.JUnit.ext)
    androidTestImplementation(TestDependencies.Espresso.core)
}