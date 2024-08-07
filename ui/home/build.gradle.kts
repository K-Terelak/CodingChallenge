plugins {
    alias(libs.plugins.cc.android.library)
    alias(libs.plugins.cc.compose)
    alias(libs.plugins.cc.hilt)
}

dependencies {
    implementation(project(":ui:common"))
    implementation(project(":navigation"))
    implementation(project(":domain:contract"))

    implementation(libs.bundles.core)
    implementation(libs.coil.compose)
}
