plugins {
    alias(libs.plugins.cc.android.library)
    alias(libs.plugins.cc.compose)
    alias(libs.plugins.cc.serialization)
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}
