plugins {
    alias(libs.plugins.cc.android.application)
    alias(libs.plugins.cc.compose)
    alias(libs.plugins.cc.hilt)
}

dependencies {
    implementation(project(":initializer:contract"))
    implementation(project(":initializer:implementation"))
    implementation(project(":data:api:contract"))
    implementation(project(":data:api:implementation"))
    implementation(project(":data:datasource:contract"))
    implementation(project(":data:datasource:implementation"))
    implementation(project(":data:repository:contract"))
    implementation(project(":data:repository:implementation"))
    implementation(project(":domain:contract"))
    implementation(project(":domain:implementation"))
    implementation(project(":di"))
    implementation(project(":navigation"))
    implementation(project(":ui:home"))
    implementation(project(":ui:common"))

    implementation(libs.bundles.core)
    implementation(libs.bundles.compose)
}
