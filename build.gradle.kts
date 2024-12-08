
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin) apply false
}

// Configurações do buildscript
buildscript {
    dependencies {
        classpath(libs.google.services) // Atualize para versão mais recente
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
        classpath(libs.koin.gradle.plugin)
    }
}