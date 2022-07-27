import Versions.compileSdk

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "edu.nextstep.camp.calculator"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
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
    testOptions {
        animationsDisabled = true
    }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.bundles.androidx)

    implementation(libs.google.material)
    implementation(libs.androidx.constraintlayout)


    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.test.android)

    implementation(project(":domain"))
}
