plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)

}

android {
    namespace = "com.example.locationreminders"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.locationreminders"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Google maps
    implementation(libs.play.services.maps.v1701)
    implementation(libs.play.services.location)

//Firebase
    implementation(libs.play.services.auth)// Para autenticação com Google
    implementation(libs.firebase.auth) // Para autenticação Firebase
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // Para ViewModel
    implementation(libs.androidx.navigation.fragment.ktx)// Para navegação entre telas
    implementation(libs.androidx.navigation.ui.ktx) // Para navegação entre telas

    //Navigation
    implementation(libs.androidx.navigation.fragment.ktx.v253)
    implementation(libs.androidx.navigation.ui.ktx.v253)
}

