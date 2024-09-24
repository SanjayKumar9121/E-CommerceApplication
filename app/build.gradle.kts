plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.saveetha.e_commerceapplicationtask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.saveetha.e_commerceapplicationtask"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.fragment.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Dagger Hilt
    implementation (libs.hilt.android)
    kapt(libs.hilt.compiler)

    // LiveData and ViewModel for MVVM
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

//    implementation (libs.androidx.hilt.lifecycle.viewmodel)
    implementation(libs.androidx.hilt.navigation.compose)

    //retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    //couroutines
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.kotlinx.coroutines.core)

    //picaso
    implementation(libs.picasso)

    kapt ("androidx.room:room-compiler:2.6.1")
    implementation (libs.androidx.room.ktx)
}