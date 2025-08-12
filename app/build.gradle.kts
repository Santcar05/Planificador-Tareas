plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    // Si quieres usar Safe Args, actívalo como plugin, no como dependencia:
    // id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.lista_tareas"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.lista_tareas"
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // BOM para Compose
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // ✅ Solo navigation-compose, quitamos jvmstubs para evitar duplicados
    implementation(libs.androidx.navigation.compose)

    // Íconos extendidos (versión tomada del BOM)
    implementation("androidx.compose.material:material-icons-extended")

    // Dependencia que trae xmlpull → excluirlo
    implementation("org.jsoup:jsoup:1.17.2") {
        exclude(group = "xmlpull", module = "xmlpull")
    }

    // Dependencia que trae xpp3 → excluirlo
    implementation("org.apache.commons:commons-compress:1.21") {
        exclude(group = "xpp3", module = "xpp3")
    }

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
