plugins {
    alias(libs.plugins.cc.android.library)
    alias(libs.plugins.cc.realm)
}

dependencies {
    implementation(project(":data:datasource:contract"))
}
