plugins {
    alias(libs.plugins.cc.android.library)
    alias(libs.plugins.cc.hilt)
}

dependencies {
    implementation(project(":initializer:contract"))
    implementation(libs.timber)
}
