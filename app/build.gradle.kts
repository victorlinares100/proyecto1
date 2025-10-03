plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.proyecto"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.proyecto"
        minSdk = 24
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0" // O la versión que corresponda
    }
}


dependencies {
    // Core dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Jetpack Compose dependencies
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material:material:1.5.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation("androidx.compose.material3:material3:1.0.0") // Si lo usas

    // Dependencies for UI elements and graphics
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)

    // Test dependencies
    testImplementation(libs.junit)  // JUnit for unit tests
    androidTestImplementation(libs.androidx.junit)  // JUnit for UI tests
    androidTestImplementation(libs.androidx.espresso.core)  // Espresso for UI testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.0") // Compose test support

    // Debugging dependencies for Compose
    debugImplementation(libs.androidx.compose.ui.tooling)  // Tooling support
    debugImplementation(libs.androidx.compose.ui.test.manifest)  // Compose test manifest

    // Additional Compose BOM (Bill of Materials) for version alignment
    implementation(platform(libs.androidx.compose.bom))  // BOM for Compose to align versions

    // Activity Compose
    implementation(libs.androidx.activity.compose)  // Activity Compose support
}


