object Dependencies {
    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.androidCore}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val lifeCycleLD = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycleLD}"
        const val supportAnimation = "androidx.dynamicanimation:dynamicanimation:${Versions.animation}"
        const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager}"

        object NavigationComponent {
            const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        }
    }

    object Squareup {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val okhttpLI = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    }

    object Koin {
        const val core = "org.koin:koin-android:${Versions.koin}"
        const val scope = "org.koin:koin-androidx-scope:${Versions.koin}"
        const val viewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    }

    object Glide {
        const val core = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val kapt = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }
}

object TestDependencies {
    object JUnit {
        const val core = "junit:junit:${Versions.jUnit}"
        const val ext = "androidx.test.ext:junit:${Versions.extJUnit}"
    }

    object Espresso {
        const val core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }
}