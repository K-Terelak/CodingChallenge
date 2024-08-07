plugins {
    alias(libs.plugins.cc.android.library)
    alias(libs.plugins.cc.compose)
}

dependencies {
    implementation(libs.coil.compose)
    implementation(libs.coil.ktor)
}
