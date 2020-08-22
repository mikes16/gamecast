object Versions {
    private const val versionMajor = 0
    private const val versionMinor = 1
    private const val versionPatch = 0

    const val buildTools = "30.0.0"
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val versionCode = versionMajor * 10000 + versionMinor * 100 + versionPatch
    const val versionName = "$versionMajor.$versionMinor.$versionPatch"

    // Deps Versions
    const val androidCore = "1.3.1"
    const val constraintlayout = "1.1.3"
    const val appCompat = "1.2.0"
    const val lifeCycleLD = "2.2.0"
    const val animation = "1.0.0"
    const val viewPager = "1.0.0"
    const val navigation = "2.3.0"
    const val retrofit = "2.7.1"
    const val koin = "2.1.5"
    const val okHttp = "4.8.1"
    const val glide = "4.11.0"

    // Testing
    const val jUnit = "4.13"
    const val extJUnit = "1.1.1"
    const val espresso = "3.2.0"
}