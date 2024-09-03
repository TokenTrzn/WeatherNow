import java.util.Properties
import java.io.FileInputStream
import java.io.IOException

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.tokentrzn.weathernow"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tokentrzn.weathernow"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "OPENWEATHERMAP_API_KEY", "\"${getApiKey()}\"")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.1")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")

    //Material Design 3
    implementation("androidx.compose.material3:material3:1.1.2")

    //NAVIGATION COMPOSE
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // DAGGER HILT
    implementation("com.google.dagger:hilt-android:2.48.1")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

    //FIREBASE
    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-auth-ktx:22.3.1")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation("com.google.firebase:firebase-firestore-ktx:25.0.0")

    //ICONS LIBRARY
    implementation ("androidx.compose.material:material-icons-extended:1.6.1")

    //RETROFIT
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //CORUTINES
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.5.2")

    //SERIALIZATION
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")


    implementation ("io.coil-kt:coil-compose:2.1.0")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

fun getApiKey(): String {
    val properties = Properties()
    try {
        properties.load(FileInputStream(rootProject.file("local.properties")))
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return properties.getProperty("OPENWEATHERMAP_API_KEY")
}