plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.teste_willowtree"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.teste_willowtree"
        minSdk = 21
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
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("io.insert-koin:koin-android:3.5.6")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
//    runtimeOnly("io.coil-kt:coil:2.7.0")
    implementation("io.coil-kt:coil:2.7.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}