plugins {
    alias(libs.plugins.cc.android.library)
    alias(libs.plugins.cc.realm)
}

dependencies {
    api(project(":data:datasource:model"))
}
