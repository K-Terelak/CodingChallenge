plugins {
    alias(libs.plugins.cc.android.library)
}

dependencies {
    implementation(project(":data:api:contract"))
    implementation(project(":data:datasource:contract"))
    implementation(project(":data:repository:contract"))
    implementation(libs.realm.base)
}
