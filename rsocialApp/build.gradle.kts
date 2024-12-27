// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Aplicando plugins necesarios
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Añadiendo el plugin de Android Gradle
        classpath ("com.android.tools.build:gradle:8.5.2") // Usar la versión más reciente compatible
        classpath ("com.google.gms:google-services:4.4.2")// Mantener la versión del plugin de Google Services
    }
}

