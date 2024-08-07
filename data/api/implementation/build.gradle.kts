plugins {
    alias(libs.plugins.cc.android.library)
    alias(libs.plugins.cc.hilt)
}

dependencies {
    implementation(project(":data:api:contract"))

    implementation(libs.bundles.ktor)
}
