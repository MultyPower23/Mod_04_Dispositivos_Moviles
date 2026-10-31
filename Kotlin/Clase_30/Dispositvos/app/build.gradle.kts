// Configuración de compilación del módulo app escrita en Kotlin (.kts) en lugar de Groovy.
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Plugin que habilita el compilador de Jetpack Compose.
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.ciro.dispositivos"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        // Identificador único de la app en el celular y en la Play Store.
        applicationId = "com.ciro.dispositivos"
        // minSdk es la versión mínima de Android que puede instalar la app; targetSdk la versión para la que se probó.
        minSdk = 28
        targetSdk = 36
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
    // Activa Compose para escribir la interfaz en Kotlin en vez de XML.
    buildFeatures {
        compose = true
    }
}

// Librerías externas que usa la app; libs.* apunta al catálogo de versiones de Gradle.
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    // El BOM fija versiones compatibles entre sí para todas las librerías de Compose.
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    // Dependencias que solo se usan en las pruebas.
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    // Solo en builds de depuración; permiten las vistas previas y la inspección de la interfaz.
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}