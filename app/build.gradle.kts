import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.dagger.hilt.android") // version "2.45" apply false
    kotlin("kapt")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.softwaret.mvi.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.20")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

    //navigation
    val navigationVersion = "2.5.3"
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")

    //retrofit
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    val okhttpVersion = "4.11.0"
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")

    //hilt
    val hiltVersion = "2.45"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-compiler:$hiltVersion")

    // For instrumentation tests
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:$hiltVersion")
    kaptAndroidTest ("com.google.dagger:hilt-compiler:$hiltVersion")

    // For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:$hiltVersion")
    kaptTest ("com.google.dagger:hilt-compiler:$hiltVersion")

    //glide
    implementation ("com.github.bumptech.glide:glide:4.15.1")
}