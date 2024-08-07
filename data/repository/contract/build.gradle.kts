plugins {
    alias(libs.plugins.cc.kotlin.library)
    alias(libs.plugins.cc.serialization)
}

dependencies {
    api(project(":domain:model"))
}
